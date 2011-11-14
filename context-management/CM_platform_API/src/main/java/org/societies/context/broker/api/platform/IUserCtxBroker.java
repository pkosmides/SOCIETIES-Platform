import WP5.Context.Informational.ContextEntityIdentifier;

/**
 * @author mcrotty
 * @version 1.0
 * @created 12-Nov-2011 7:15:15 PM
 */
public interface IUserCtxBroker {

	/**
	 * Creates a CtxAssociation
	 * 
	 * @param type
	 * @param callback
	 */
	public void createAssociation(String type, IUserCtxBrokerCallback callback);

	/**
	 * Creates a CtxAttribute
	 * 
	 * @param scope
	 * @param enum
	 * @param type
	 * @param callback
	 */
	public void createAttribute(ContextEntityIdentifier scope, ContextAttributeValueType enum, string type, IUserCtxBrokerCallback callback);

	/**
	 * Creates a CtxEntity
	 * 
	 * @param type
	 * @param callback
	 */
	public void createEntity(String type, IUserCtxBrokerCallback callback);

	/**
	 * 
	 * @param type
	 */
	public disableCtxMonitoring(ContextAttributeValueType type);

	public void disableCtxRecording();

	/**
	 * 
	 * @param type
	 */
	public enableCtxMonitoring(ContextAttributeValueType type);

	public void enableCtxRecording();

	/**
	 * There are several methods missing that would express the similarity of context
	 * values or objects in a quantifiable form (and not via a sorted list of
	 * most/least similar reference objects/values).
	 * 
	 * @param objectUnderComparison
	 * @param referenceObjects
	 * @param callback
	 */
	public void evaluateSimilarity(Serializable objectUnderComparison, List<Serializable> referenceObjects, IUserCtxBrokerCallback callback);

	/**
	 * 
	 * @param predMethod
	 */
	public PredictionMethod  getDefaultPredictionMethod(PredictionMethod predMethod);

	/**
	 * 
	 * @param predMethod
	 */
	public PredictionMethod  getPredictionMethod(PredictionMethod predMethod);

	/**
	 * Looks up for a list of CtxModelObjects defined by the CtxModelType (CtxEntity,
	 * CtxAttribute, CtxAssociation) of  the specified type.
	 * 
	 * @param modelType
	 * @param type
	 * @param callback
	 */
	public void lookup(CtxModelType modelType, String type, IUserCtxBrokerCallback callback);

	/**
	 * Looks up for a list of CtxEntities of  the specified type, containing the
	 * specified attributes
	 * 
	 * @param entityType
	 * @param attribType
	 * @param minAttribValue
	 * @param maxAttribValue
	 * @param callback
	 */
	public void lookupEntities(String entityType, String attribType, Serializable minAttribValue, Serializable maxAttribValue, IUserCtxBrokerCallback callback);

	/**
	 * Registers the specified EventListener for value modification events of context
	 * attribute(s) with the supplied scope and type.
	 * 
	 * @param scope
	 * @param attrType
	 * @param callback
	 */
	public void registerForUpdates(ContextEntityIdentifier scope, String attrType, IUserCtxBrokerCallback callback);

	/**
	 * Registers the specified EventListener for value modification events of the
	 * specified context attribute.
	 * 
	 * @param attrId
	 * @param callback
	 */
	public void registerForUpdates(ContextAttributeIdentifier attrId, IUserCtxBrokerCallback callback);

	/**
	 * Removes the specified context model object.
	 * 
	 * @param identifier
	 * @param callback
	 */
	public void remove(ContextIdentifier identifier, IUserCtxBrokerCallback callback);

	/**
	 * 
	 * @param type
	 * @param startDate
	 * @param endDate
	 */
	public int removeHistory(String type, Date startDate, Date endDate);

	/**
	 * 
	 * @param predMethod
	 */
	public void removePredictionMethod(PredictionMethod predMethod);

	/**
	 * Retrieves the specified context model object.
	 * 
	 * @param identifier
	 * @param callback
	 */
	public void retrieve(ContextIdentifier identifier, IUserCtxBrokerCallback callback);

	/**
	 * Predicts a future context attribute for the specified time.
	 * 
	 * @param attrId
	 * @param date
	 * @param callback
	 */
	public void retrieveFuture(ContextAttributeIdentifier attrId, Date date, IUserCtxBrokerCallback callback);

	/**
	 * Predicts the identified by the modification index  future context attribute.
	 * 
	 * @param attrId
	 * @param modificationIndex
	 * @param callback
	 */
	public void retrieveFuture(ContextAttributeIdentifier attrId, int modificationIndex, IUserCtxBrokerCallback callback);

	/**
	 * Retrieves context attributes stored in the Context History Log based on the
	 * specified modificationIndex.
	 * 
	 * @param attrId
	 * @param modificationIndex
	 * @param callback
	 */
	public void retrievePast(ContextAttributeIdentifier attrId, int modificationIndex, IUserCtxBrokerCallback callback);

	/**
	 * Retrieves context attributes stored in the Context History Log based on the
	 * specified date and time information.
	 * 
	 * @param attrId
	 * @param startDate
	 * @param endDate
	 * @param callback
	 */
	public void retrievePast(ContextAttributeIdentifier attrId, Date startDate, Date endDate, IUserCtxBrokerCallback callback);

	/**
	 * 
	 * @param predMethod
	 */
	public void setDefaultPredictionMethod(PredictionMethod predMethod);

	/**
	 * 
	 * @param predMethod
	 * @param callback
	 */
	public void setPredictionMethod(PredictionMethod predMethod, IUserCtxBrokerCallback callback);

	/**
	 * Registers the specified EventListener for value modification events of the
	 * specified context attribute.
	 * 
	 * @param attrId
	 * @param callback
	 */
	public void unregisterForUpdates(ContextAttributeIdentifier attrId, IUserCtxBrokerCallback callback);

	/**
	 * Unregisters the specified EventListener for value modification events of
	 * context attribute(s) with the supplied scope and type.
	 * 
	 * @param scope
	 * @param attributeType
	 * @param callback
	 */
	public void unregisterForUpdates(ContextEntityIdentifier scope, String attributeType, IUserCtxBrokerCallback callback);

	/**
	 * Updates a single context model object.
	 * 
	 * @param identifier
	 * @param callback
	 */
	public void update(ContextModelObject identifier, IUserCtxBrokerCallback callback);

}