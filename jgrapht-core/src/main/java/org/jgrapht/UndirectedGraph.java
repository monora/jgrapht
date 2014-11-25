package org.jgrapht;

public interface UndirectedGraph<V, E> extends Graph<V,E> {

	/**
	 * Returns the degree of the specified vertex. A degree of a vertex in an
	 * undirected graph is the number of edges touching that vertex.
	 *
	 * @param vertex vertex whose degree is to be calculated.
	 *
	 * @return the degree of the specified vertex.
	 */
	public int degreeOf(V vertex);

}
