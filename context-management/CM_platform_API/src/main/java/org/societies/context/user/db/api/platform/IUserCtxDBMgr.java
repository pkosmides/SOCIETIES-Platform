import WP5.Context.Informational.ContextEntityIdentifier;

/**
 * @author mcrotty
 * @version 1.0
 * @created 12-Nov-2011 7:15:15 PM
 */
public interface IUserCtxDBMgr {

	/**
	 * Creates a CtxAssociation
	 * 
	 * @param type
	 * @param callback
	 */
	public void createAssociation(String type, IUserCtxDBMgrCallback callback);

	/**
	 * Creates a CtxAttribute
	 * 
	 * @param source
	 * @param enum
	 * @param type
	 * @param callback
	 */
	public void createAttribute(ContextEntityIdentifier source, ContextAttributeValueType enum, string type, IUserCtxDBMgrCallback callback);

	/**
	 * Creates a CtxEntity
	 * 
	 * @param type
	 * @param callback
	 */
	public void createEntity(String type, IUserCtxDBMgrCallback callback);

	/**
	 * Looks up for a list of CtxModelObjects defined by the CtxModelType (CtxEntity,
	 * CtxAttribute, CtxAssociation) of  the specified type.
	 * 
	 * @param modelType
	 * @param type
	 * @param callback
	 */
	public void lookup(CtxModelType modelType, String type, IUserCtxDBMgrCallback callback);

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
	public void lookupEntities(String entityType, String attribType, Serializable minAttribValue, Serializable maxAttribValue, IUserCtxDBMgrCallback callback);

	/**
	 * Registers the specified EventListener for value modification events of context
	 * attribute(s) with the supplied scope and type.
	 * 
	 * @param scope
	 * @param attrType
	 * @param callback
	 */
	public void registerForUpdates(ContextEntityIdentifier scope, String attrType, IUserCtxDBMgrCallback callback);

	/**
	 * Registers the specified EventListener for value modification events of the
	 * specified context attribute.
	 * 
	 * @param attrId
	 * @param callback
	 */
	public void registerForUpdates(ContextAttributeIdentifier attrId, IUserCtxDBMgrCallback callback);

	/**
	 * Removes the specified context model object.
	 * 
	 * @param identifier
	 * @param callback
	 */
	public void remove(ContextIdentifier identifier, IUserCtxDBMgrCallback callback);

	/**
	 * Retrieves the specified context model object.
	 * 
	 * @param identifier
	 * @param callback
	 */
	public void retrieve(ContextIdentifier identifier, IUserCtxDBMgrCallback callback);

	/**
	 * Registers the specified EventListener for value modification events of the
	 * specified context attribute.
	 * 
	 * @param attrId
	 * @param callback
	 */
	public void unregisterForUpdates(ContextAttributeIdentifier attrId, IUserCtxDBMgrCallback callback);

	/**
	 * Unregisters the specified EventListener for value modification events of
	 * context attribute(s) with the supplied scope and type.
	 * 
	 * @param scope
	 * @param attributeType
	 * @param callback
	 */
	public void unregisterForUpdates(ContextEntityIdentifier scope, String attributeType, IUserCtxDBMgrCallback callback);

	/**
	 * Updates a single context model object.
	 * 
	 * @param identifier
	 * @param callback
	 */
	public void update(ContextModelObject identifier, IUserCtxDBMgrCallback callback);

}