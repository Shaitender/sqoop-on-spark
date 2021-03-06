/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.security;

import org.apache.sqoop.common.SqoopException;
import org.apache.sqoop.model.MPrincipal;
import org.apache.sqoop.model.MPrivilege;
import org.apache.sqoop.model.MResource;
import org.apache.sqoop.model.MRole;

import java.util.List;

/**
 * AuthorizationHandler is responsible for controlling role based access.
 */
public abstract class AuthorizationHandler {

  public abstract void doInitialize(AuthenticationProvider provider, String serverName) throws ClassNotFoundException, IllegalAccessException, InstantiationException;

  /**
   * Role related function
   */
  public abstract void createRole(MRole role) throws SqoopException;

  public abstract void dropRole(MRole role) throws SqoopException;

  public abstract List<MRole> getAllRoles() throws SqoopException;

  public abstract List<MRole> getRolesByPrincipal(MPrincipal principal) throws SqoopException;

  /**
   * Principal related function
   */
  public abstract List<MPrincipal> getPrincipalsByRole(MRole role) throws SqoopException;

  public abstract void grantRole(List<MPrincipal> principals, List<MRole> roles) throws SqoopException;

  public abstract void revokeRole(List<MPrincipal> principals, List<MRole> roles) throws SqoopException;

  /**
   * Resource related function
   */
  public abstract void updateResource(MResource old_resource, MResource new_resource) throws SqoopException;

  public abstract void removeResource(MResource resource) throws SqoopException;

  /**
   * Privilege related function
   */
  public abstract List<MPrivilege> getPrivilegesByPrincipal(MPrincipal principal, MResource resource) throws SqoopException;

  public abstract void grantPrivileges(List<MPrincipal> principals, List<MPrivilege> privileges) throws SqoopException;

  public abstract void revokePrivileges(List<MPrincipal> principals, List<MPrivilege> privileges) throws SqoopException;

  /**
   * Validator related function
   */
  public abstract void checkPrivileges(MPrincipal principal, List<MPrivilege> privileges) throws SqoopException;
}