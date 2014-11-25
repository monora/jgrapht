package org.jgrapht;

import java.util.Set;

public interface Graph<V, E> {

	/**
	 * Returns a set of all edges connecting source vertex to target vertex if
	 * such vertices exist in this graph. If any of the vertices does not exist
	 * or is <code>null</code>, returns <code>null</code>. If both vertices
	 * exist but no edges found, returns an empty set.
	 *
	 * <p>In undirected graphs, some of the returned edges may have their source
	 * and target vertices in the opposite order. In simple graphs the returned
	 * set is either singleton set or empty set.</p>
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param targetVertex target vertex of the edge.
	 *
	 * @return a set of all edges connecting source vertex to target vertex.
	 */
	public Set<E> getAllEdges(V sourceVertex, V targetVertex);

	/**
	 * Returns an edge connecting source vertex to target vertex if such
	 * vertices and such edge exist in this graph. Otherwise returns <code>
	 * null</code>. If any of the specified vertices is <code>null</code>
	 * returns <code>null</code>
	 *
	 * <p>In undirected graphs, the returned edge may have its source and target
	 * vertices in the opposite order.</p>
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param targetVertex target vertex of the edge.
	 *
	 * @return an edge connecting source vertex to target vertex.
	 */
	public E getEdge(V sourceVertex, V targetVertex);

	/**
	 * Returns the edge factory using which this graph creates new edges. The
	 * edge factory is defined when the graph is constructed and must not be
	 * modified.
	 *
	 * @return the edge factory using which this graph creates new edges.
	 */
	public EdgeFactory<V, E> getEdgeFactory();

	/**
	 * Returns <tt>true</tt> if and only if this graph contains an edge going
	 * from the source vertex to the target vertex. In undirected graphs the
	 * same result is obtained when source and target are inverted. If any of
	 * the specified vertices does not exist in the graph, or if is <code>
	 * null</code>, returns <code>false</code>.
	 *
	 * @param sourceVertex source vertex of the edge.
	 * @param targetVertex target vertex of the edge.
	 *
	 * @return <tt>true</tt> if this graph contains the specified edge.
	 */
	public boolean containsEdge(V sourceVertex, V targetVertex);

	/**
	 * Returns <tt>true</tt> if this graph contains the specified edge. More
	 * formally, returns <tt>true</tt> if and only if this graph contains an
	 * edge <code>e2</code> such that <code>e.equals(e2)</code>. If the
	 * specified edge is <code>null</code> returns <code>false</code>.
	 *
	 * @param e edge whose presence in this graph is to be tested.
	 *
	 * @return <tt>true</tt> if this graph contains the specified edge.
	 */
	public boolean containsEdge(E e);

	/**
	 * Returns <tt>true</tt> if this graph contains the specified vertex. More
	 * formally, returns <tt>true</tt> if and only if this graph contains a
	 * vertex <code>u</code> such that <code>u.equals(v)</code>. If the
	 * specified vertex is <code>null</code> returns <code>false</code>.
	 *
	 * @param v vertex whose presence in this graph is to be tested.
	 *
	 * @return <tt>true</tt> if this graph contains the specified vertex.
	 */
	public boolean containsVertex(V v);

	/**
	 * Returns a set of the edges contained in this graph. The set is backed by
	 * the graph, so changes to the graph are reflected in the set. If the graph
	 * is modified while an iteration over the set is in progress, the results
	 * of the iteration are undefined.
	 *
	 * <p>The graph implementation may maintain a particular set ordering (e.g.
	 * via {@link java.util.LinkedHashSet}) for deterministic iteration, but
	 * this is not required. It is the responsibility of callers who rely on
	 * this behavior to only use graph implementations which support it.</p>
	 *
	 * @return a set of the edges contained in this graph.
	 */
	public Set<E> edgeSet();

	/**
	 * Returns a set of all edges touching the specified vertex. If no edges are
	 * touching the specified vertex returns an empty set.
	 *
	 * @param vertex the vertex for which a set of touching edges is to be
	 * returned.
	 *
	 * @return a set of all edges touching the specified vertex.
	 *
	 * @throws IllegalArgumentException if vertex is not found in the graph.
	 * @throws NullPointerException if vertex is <code>null</code>.
	 */
	public Set<E> edgesOf(V vertex);

	/**
	 * Returns a set of the vertices contained in this graph. The set is backed
	 * by the graph, so changes to the graph are reflected in the set. If the
	 * graph is modified while an iteration over the set is in progress, the
	 * results of the iteration are undefined.
	 *
	 * <p>The graph implementation may maintain a particular set ordering (e.g.
	 * via {@link java.util.LinkedHashSet}) for deterministic iteration, but
	 * this is not required. It is the responsibility of callers who rely on
	 * this behavior to only use graph implementations which support it.</p>
	 *
	 * @return a set view of the vertices contained in this graph.
	 */
	public Set<V> vertexSet();

	/**
	 * Returns the source vertex of an edge. For an undirected graph, source and
	 * target are distinguishable designations (but without any mathematical
	 * meaning).
	 *
	 * @param e edge of interest
	 *
	 * @return source vertex
	 */
	public V getEdgeSource(E e);

	/**
	 * Returns the target vertex of an edge. For an undirected graph, source and
	 * target are distinguishable designations (but without any mathematical
	 * meaning).
	 *
	 * @param e edge of interest
	 *
	 * @return target vertex
	 */
	public V getEdgeTarget(E e);

	/**
	 * Returns the weight assigned to a given edge. Unweighted graphs return 1.0
	 * (as defined by {@link WeightedGraph#DEFAULT_EDGE_WEIGHT}), allowing
	 * weighted-graph algorithms to apply to them where meaningful.
	 *
	 * @param e edge of interest
	 *
	 * @return edge weight
	 *
	 * @see WeightedGraph
	 */
	public double getEdgeWeight(E e);

}
