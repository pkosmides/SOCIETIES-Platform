var RosterManager = {
		onRosterUpdated: function(items) {
			$('#roster div').html('');
			$('#roster div').append('<ul>');
			$(items).each(function () {
				var jid = this.jid;
				var name = this.name || jid;
				var groups = this.groups;
				var resources = this.resources;
				var status = '';
				if (resources.myresource != undefined) {
					status = resources.myresource.status;
				}
				$('<li>').html('<span class="roster-groups">['+groups+']</span>'+
						' <span class="roster-name">'+name+'</span>'+
						' (<span class="roster-jid">'+jid+'</span>)'+
						' <span class="roster-status">'+('' != status ? status : '')+'</span>'+
						'</li>').appendTo('#roster div ul');
			});
			$('#roster div').append('</ul>');
			
			// Return true to continue to handle roster updates
			return true;
		},

		start: function() {
			// -- We are using the Strophe.roster plugin (see plugin/strophe.roster.js)
			// Register our callback
			Client.connection.roster.registerCallback(RosterManager.onRosterUpdated);
			// Ask for roster updates
			Client.connection.roster.get();
			
			// -- We are sending below ram iq stanzas
//			var NS_IQ_ROSTER = 'jabber:iq:roster';
//			var iq = $iq({type: 'get'}).c('query', {xmlns: NS_IQ_ROSTER});
//			Client.connection.sendIQ(iq, RosterManager.onRosterUpdated);
//			Controler.connection.addHandler(RosterManager.onRosterUpdated, NS_IQ_ROSTER, 'iq', 'set');
		}
}
