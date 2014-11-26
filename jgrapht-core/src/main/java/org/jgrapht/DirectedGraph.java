package org.jgrapht;

import java.util.Set;

public interface DirectedGraph<V, E> extends Graph<V,E> {

	/**
	 * Returns the "in degree" of the specified vertex. An in degree of a vertex
	 * in a directed graph is the number of inward directed edges from that
	 * vertex. See <a href="http://mathworld.wolfram.com/Indegree.html">
	 * http://mathworld.wolfram.com/Indegree.html</a>.
	 *
	 * @param vertex vertex whose degree is to be calculated.
	 *
	 * @return the degree of the specified vertex.
	 */
	public int inDegreeOf(V vertex);

	/**
	 * Returns a set of all edges incoming into the specified vertex.
	 *
	 * @param vertex the vertex for which the list of incoming edges to be
	 * returned.
	 *
	 * @return a set of all edges incoming into the specified vertex.
	 */
	public Set<E> incomingEdgesOf(V vertex);

	/**
	 * Returns the "out degree" of the specified vertex. An out degree of a
	 * vertex in a directed graph is the number of outward directed edges from
	 * that vertex. See <a href="http://mathworld.wolfram.com/Outdegree.html">
	 * http://mathworld.wolfram.com/Outdegree.html</a>.
	 *
	 * @param vertex vertex whose degree is to be calculated.
	 *
	 * @return the degree of the specified vertex.
	 */
	public int outDegreeOf(V vertex);

	/**
	 * Returns a set of all edges outgoing from the specified vertex.
	 *
	 * @param vertex the vertex for which the list of outgoing edges to be
	 * returned.
	 *
	 * @return a set of all edges outgoing from the specified vertex.
	 */
	public Set<E> outgoingEdgesOf(V vertex);

}
