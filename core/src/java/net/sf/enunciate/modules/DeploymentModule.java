package net.sf.enunciate.modules;

import net.sf.enunciate.main.Enunciate;
import org.apache.commons.digester.RuleSet;

import java.io.IOException;

/**
 * Interface for a deployment module.  A deployment module for a specific platform implements logic for each
 * enunciate step.
 *
 * @author Ryan Heaton
 */
public interface DeploymentModule {

  /**
   * The name of the deployment module.  Along with the {@link #getNamespace(), namespace} identifies
   * its section in the enunciate configuration.
   *
   * @return The name of the deployment module.
   */
  String getName();

  /**
   * The namespace for this deployment module.  Along with the {@link #getName(), name} identifies
   * its section in the enunciate configuration.
   *
   * @return The namespace for this module.
   */
  String getNamespace();

  /**
   * Initialize this deployment module with the specified enunciate mechanism.
   *
   * @param enunciate The enunciate mechanism.
   */
  void init(Enunciate enunciate);

  /**
   * Step to the next enunciate target.
   *
   * @param target The enunciate target to step to.
   */
  void step(Enunciate.Target target) throws IOException;

  /**
   * Close this enunciate module.
   */
  void close();

  /**
   * The configuration rules for this deployment module, or null if none.
   *
   * @return The configuration rules for this deployment module.
   */
  RuleSet getConfigurationRules();

  /**
   * The order of execution for the deployment module.
   *
   * @return The order of execution for the deployment module.
   */
  int getOrder();

}