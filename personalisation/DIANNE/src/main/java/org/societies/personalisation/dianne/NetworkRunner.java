/**
 * Copyright (c) 2011, SOCIETIES Consortium (WATERFORD INSTITUTE OF TECHNOLOGY (TSSG), HERIOT-WATT UNIVERSITY (HWU), SOLUTA.NET 
 * (SN), GERMAN AEROSPACE CENTRE (Deutsches Zentrum fuer Luft- und Raumfahrt e.V.) (DLR), Zavod za varnostne tehnologije
 * informacijske družbe in elektronsko poslovanje (SETCCE), INSTITUTE OF COMMUNICATION AND COMPUTER SYSTEMS (ICCS), LAKE
 * COMMUNICATIONS (LAKE), INTEL PERFORMANCE LEARNING SOLUTIONS LTD (INTEL), PORTUGAL TELECOM INOVAÇÃO, SA (PTIN), IBM Corp., 
 * INSTITUT TELECOM (ITSUD), AMITEC DIACHYTI EFYIA PLIROFORIKI KAI EPIKINONIES ETERIA PERIORISMENIS EFTHINIS (AMITEC), TELECOM 
 * ITALIA S.p.a.(TI),  TRIALOG (TRIALOG), Stiftelsen SINTEF (SINTEF), NEC EUROPE LTD (NEC))
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following
 * conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
 *    disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.societies.personalisation.dianne;

import java.util.ArrayList;
import java.util.Iterator;

import org.societies.personalisation.dianne.model.ContextNode;
import org.societies.personalisation.dianne.model.Network;
import org.societies.personalisation.dianne.model.ContextGroup;
import org.societies.personalisation.dianne.model.Node;
import org.societies.personalisation.dianne.model.OutcomeGroup;
import org.societies.personalisation.dianne.model.OutcomeNode;
import org.societies.personalisation.dianne.model.Synapse;
import org.societies.api.personalisation.model.IAction;
import org.societies.api.mock.ServiceResourceIdentifier;

public class NetworkRunner implements Runnable{

	public Network networkModel;
	private NetworkBuffer buffer;
	private int nur = 1000;  //network update rate
	private int contextNodeCount;
	private int outcomeNodeCount;

	//for threads
	private Thread myThread;
	private Object pauseMonitor = new Object();
	private boolean paused = false;

	public NetworkRunner(){
		networkModel= new Network();
		buffer = new NetworkBuffer();
		contextNodeCount = 0;
		outcomeNodeCount = 0;

		//start thread
		myThread = new Thread(this);
		myThread.setName("EntityIdentifier");
		myThread.start();
	}

	@Override
	public void run() {
		while(true)
		{                       
			updateNetwork(); 
			synchronized (pauseMonitor){ //check for disable
				if(paused){
					try{
						pauseMonitor.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void play(){
		synchronized(pauseMonitor){
			paused = false;
			pauseMonitor.notify();
		}
	}

	public void pause(){
		synchronized (pauseMonitor){
			paused = true;
		}
	}

	private void updateNetwork(){
		ArrayList<IAction>[] snapshot = buffer.getSnapshot();
		updateContextLayer(snapshot[0]);  //set network to reflect context updates
		updateOutcomeLayer(snapshot[1]);  //set network to reflect outcome updates
		updateNetworkOutput();  //update synapses and outcomes
		try {
			Thread.sleep(nur);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***********************************************************************************
	 * Update network methods
	 ***********************************************************************************/
	/*
	 * Context layer update methods
	 */
	public void updateContextLayer(ArrayList<IAction> contextUpdates)
	{
		Iterator<IAction> contextUpdates_it = contextUpdates.iterator();
		while(contextUpdates_it.hasNext())
		{
			IAction nextUpdate = (IAction)contextUpdates_it.next();

			String groupName = nextUpdate.getparameterName();
			String nodeName = nextUpdate.getvalue();

			//search for group
			ContextGroup contextGroup = networkModel.getContextGroup(groupName);
			if(contextGroup != null) //group exists
			{
				//file.println("Group "+groupName+" already exists");

				//search for node
				ContextNode contextNode = (ContextNode)contextGroup.getNode(nodeName);
				if(contextNode != null) //node exists in group
				{
					//file.println("Node "+nodeName+" already exists");
					//activate node in group (deactivates all others)
					activateContextUpdate(contextGroup, contextNode);

				}else{ //no such node exsist in group

					//file.println("Node "+nodeName+" doesn't exist, creating new");
					//create node, add it to group and activate
					createNewContextNode(contextGroup, nodeName);
				}

			}else{ //no such group exists

				//file.println("Group "+groupName+" doesn't exist, creating new with node "+nodeName);
				//create group including new node and activate
				createNewContextGroup(groupName, nodeName);
			}
		}
	}

	public void activateContextUpdate(ContextGroup contextGroup, ContextNode contextNode)
	{
		//activate context node
		contextGroup.activateNode(contextNode);
		//refresh network outcomes
		refreshActiveNodes();
	}

	public void createNewContextNode(ContextGroup contextGroup, String nodeName)
	{
		//create new context node
		ContextNode newContextNode = new ContextNode(contextNodeCount, contextGroup.getGroupName(), nodeName);
		contextNodeCount++;
		//add new node to context group and activate
		contextGroup.addNode(newContextNode);
		//create synapses to outcome nodes
		connectOutcomes(newContextNode);
		//refresh network outcomes
		refreshActiveNodes();
	}

	public void createNewContextGroup(String groupName, String nodeName)
	{
		//create new context group
		ContextGroup newContextGroup = new ContextGroup(groupName);
		//create new context node for group
		createNewContextNode(newContextGroup, nodeName);
		//add new group to list
		networkModel.addContextGroup(newContextGroup);
	}
	
	private void refreshActiveNodes()
	{
		//update outcome node potentials
		//activate nodes with highest potentials
		Iterator<OutcomeGroup> outcomeGroups_it = networkModel.getOutcomeGroups().iterator();
		while(outcomeGroups_it.hasNext())
		{
			OutcomeGroup nextGroup = (OutcomeGroup)outcomeGroups_it.next();
			nextGroup.refreshOutcomes();
		}
	}

	/*
	 * Outcome layer update methods
	 */
	public void updateOutcomeLayer(ArrayList<IAction> outcomeUpdates)
	{	
		Iterator<IAction> outcomeUpdates_it = outcomeUpdates.iterator();
		while(outcomeUpdates_it.hasNext())
		{
			IAction nextUpdate = (IAction)outcomeUpdates_it.next();

			ServiceResourceIdentifier serviceId = nextUpdate.getServiceID();
			String serviceType = nextUpdate.getServiceType();
			String groupName = nextUpdate.getparameterName();
			String nodeName = nextUpdate.getvalue();

			//search for group
			OutcomeGroup outcomeGroup = networkModel.getOutcomeGroup(serviceId, groupName);
			if(outcomeGroup != null) //group exists
			{
				//file.println("Group "+groupName+" already exists");

				//search for node
				OutcomeNode outcomeNode = (OutcomeNode)outcomeGroup.getNode(nodeName);
				if(outcomeNode != null)  //node exists in group
				{
					//file.println("Node "+nodeName+" already exists");
					//activate node in group (deactivates all others)
					activateOutcomeUpdate(outcomeGroup, outcomeNode);

				}else{  //no such node exists in group

					//file.println("Node "+nodeName+" doesn't exist, creating new");
					//create node, add it to group and activate
					createNewOutcomeNode(outcomeGroup, nodeName);
				}

			}else{ //no such group exists

				//file.println("Group "+groupName+" under serviceId "+serviceId+" doesn't exist, creating new with node "+nodeName);
				//create group including new node and activate
				createNewOutcomeGroup(serviceId, serviceType, groupName, nodeName);
			}
		}
	}

	public void activateOutcomeUpdate(OutcomeGroup outcomeGroup, OutcomeNode outcomeNode)
	{
		//activate outcome node
		outcomeGroup.userActivateNode(outcomeNode);
	}

	public void createNewOutcomeNode(OutcomeGroup outcomeGroup, String nodeName)
	{
		OutcomeNode newOutcomeNode = new OutcomeNode(outcomeNodeCount, outcomeGroup.getGroupName(), nodeName);
		outcomeNodeCount++;
		//add new node to outcome group
		outcomeGroup.addNode(newOutcomeNode);
		//create synapses to context nodes
		connectContext(newOutcomeNode);
		//activate new node in group
		activateOutcomeUpdate(outcomeGroup, newOutcomeNode);
	}

	public void createNewOutcomeGroup(ServiceResourceIdentifier serviceId, String serviceType, String groupName, String nodeName)
	{
		//create new outcome group
		OutcomeGroup newOutcomeGroup = new OutcomeGroup(serviceId, serviceType, groupName);
		//create new outcome node for group
		createNewOutcomeNode(newOutcomeGroup, nodeName);
		//add new group to list
		networkModel.addOutcomeGroup(newOutcomeGroup);
	}

	private void connectOutcomes(ContextNode node){
		int preNodeID = node.getID();

		Iterator<OutcomeGroup> list_it = networkModel.getOutcomeGroups().iterator();
		while(list_it.hasNext())
		{
			OutcomeGroup nextGroup = (OutcomeGroup)list_it.next();
			ArrayList<Node> nodes = nextGroup.getGroupNodes();

			Iterator<Node> nodes_it = nodes.iterator();
			while(nodes_it.hasNext())
			{
				Node nextNode = (Node)nodes_it.next();
				int postNodeID = nextNode.getID();

				String synapseID = postNodeID+"_"+preNodeID;

				//Create new Synapse with id, pre-node and post-node
				Synapse synapse = new Synapse(synapseID, (ContextNode)node, (OutcomeNode)nextNode); //node=context, nextnode=outcome

				//add synapse to pre and post nodes
				node.addSynapse(synapse);
				nextNode.addSynapse(synapse);

				networkModel.addSynapse(synapse);
			}
		}
	}

	private void connectContext(OutcomeNode node){
		int postNodeID = node.getID();

		Iterator<ContextGroup> list_it = networkModel.getContextGroups().iterator();
		while(list_it.hasNext())
		{
			ContextGroup nextGroup = (ContextGroup)list_it.next();
			ArrayList<Node> nodes = nextGroup.getGroupNodes();

			Iterator<Node> nodes_it = nodes.iterator();
			while(nodes_it.hasNext())
			{
				Node nextNode = (Node)nodes_it.next();
				int preNodeID = nextNode.getID();

				String synapseID = postNodeID+"_"+preNodeID;

				//Create new Synapse with id, pre-node and post-node
				Synapse synapse = new Synapse(synapseID, (ContextNode)nextNode, (OutcomeNode)node); //node=outcome, nextnode=context

				//add synapse to pre and post nodes
				node.addSynapse(synapse);
				nextNode.addSynapse(synapse);

				networkModel.addSynapse(synapse);
			}
		}
	}
	
	/*
	 * Network output update methods
	 */
	public void updateNetworkOutput()
	{
		//update synapses
		updateSynapses();
		//calculate new winners and communicate
		Iterator<OutcomeGroup> outcomeGroups_it = networkModel.getOutcomeGroups().iterator();
		while(outcomeGroups_it.hasNext())
		{
			OutcomeGroup nextGroup = (OutcomeGroup)outcomeGroups_it.next();
			nextGroup.updateGroupOutput();
		}
	}

	public void updateSynapses()
	{
		Iterator<Synapse> synapses_it = networkModel.getSynapses().iterator();
		while(synapses_it.hasNext())
		{
			Synapse nextSynapse = (Synapse)synapses_it.next();
			nextSynapse.updateWeight();
		}
	}
}
