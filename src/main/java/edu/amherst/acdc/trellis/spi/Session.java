/*
 * Copyright Amherst College
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.amherst.acdc.trellis.spi;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

import org.apache.commons.rdf.api.IRI;

/**
 * This interface represents a user's session when interacting with a repository resource.
 * All changes made during the session will be persisted to durable storage with the save()
 * method.
 *
 * A session may or may not expire. If an expriation has been set, that expiry may be extended.
 *
 * Users, groups and delegates are represented as IRIs.
 *
 * @author acoburn
 */
public interface Session {

    /**
     * Get a session identifier
     * @return a session identifier
     */
    IRI getIdentifier();

    /**
     * Get a user identifier
     * @return an identifier for a User
     */
    IRI getUser();

    /**
     * Get additional (e.g. group) identifiers for this session
     * @return any additional user/group identifiers
     */
    Collection<IRI> getGroups();

    /**
     * Get the user that delegated access, if one exists
     * @return the user who delegated access
     */
    Optional<IRI> getDelegatedBy();

    /**
     * Get the date when the session was created.
     * @return the creation date
     */
    Instant getCreated();

    /**
     * Get the expiration date, if one exists
     * @return the expiration date, if one exists
     */
    Optional<Instant> getExpiry();

    /**
     * Update the expiry by the provided amount
     * @param amount the amount of time to add
     * @return the new expiration date
     */
    Instant updateExpiry(Duration amount);

    /**
     * Commit any changes associated with this session to durable persistence
     */
    void commit();

    /**
     * Expire the session
     */
    void expire();
}