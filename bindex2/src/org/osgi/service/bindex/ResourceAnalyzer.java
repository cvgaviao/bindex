package org.osgi.service.bindex;

import java.util.List;

/**
 * <p>
 * A resource analyzer is responsible for analyzing a resource for some specific
 * purpose, and discovering requirements and capabilities that may not be
 * discovered by the basic Bundle Analyzer.
 * </p>
 * 
 * <p>
 * Clients may implement this interface and register instances as services.
 * </p>
 * 
 * @author Neil Bartlett <njbartlett@gmail.com>
 */
public interface ResourceAnalyzer {

	/**
	 * The service property used to declare a resource filter, so that the
	 * analyzer is only invoked on a subset of resources. Example:
	 * <code>(&(|(name=foo.jar)(name=*.ear))(lastmodified>=1262217600753)) </code>
	 */
	static final String FILTER = "filter";

	/**
	 * This method is invoked for each resource that the analyzer is requested
	 * to analyze.
	 * 
	 * @param resource
	 *            The current resource.
	 * @param capabilities
	 *            The list of capabilities. Implementations are permitted to add
	 *            to this list but must not remove or update any existing
	 *            entries.
	 * @param requirements
	 *            The list of requirements. Implementations are permitted to add
	 *            to this list but must not remove or update any existing
	 *            entries.
	 * @throws Exception
	 */
	void analyzeResource(Resource resource, List<? super Capability> capabilities, List<? super Requirement> requirements) throws Exception;

}
