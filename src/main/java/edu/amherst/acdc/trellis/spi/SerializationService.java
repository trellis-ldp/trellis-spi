/*
 * Copyright 2016 Amherst College
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

import java.io.OutputStream;
import java.util.stream.Stream;

import edu.amherst.acdc.trellis.api.Event;
import org.apache.commons.rdf.api.RDFSyntax;
import org.apache.commons.rdf.api.Triple;

/**
 * The SerializationService defines methods for serializing RDF streams
 * in a concrete RDF 1.1 syntax.
 *
 * @author acoburn
 */
public interface SerializationService {

    /**
     * Serialize the triple stream as RDF
     * @param triples the stream of triples
     * @param output the output stream
     * @param syntax the output format
     */
    void serialize(Stream<Triple> triples, OutputStream output, RDFSyntax syntax);

    /**
     * Serialize the triple stream as RDF
     * @param triples the stream of triples
     * @param output the output stream
     * @param syntax the output format
     * @param profile additional profile information used for output
     */
    void serialize(Stream<Triple> triples, OutputStream output, RDFSyntax syntax, String profile);


    /**
     * Serialize an event as RDF
     * @param event the event
     * @param output the output stream
     * @param syntax the output format
     */
    void serialize(Event event, OutputStream output, RDFSyntax syntax);
}
