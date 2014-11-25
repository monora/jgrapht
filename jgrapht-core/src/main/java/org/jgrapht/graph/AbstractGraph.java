package org.jgrapht.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jgrapht.DirectedMutableGraph;
import org.jgrapht.Graph;
import org.jgrapht.MutableGraph;
import org.jgrapht.util.TypeUtil;


public abstract class AbstractGraph<V, E> implements Graph<V, E> {

	/**
	 * @see MutableGraph#containsEdge(Object, Object)
	 */
	public boolean containsEdge(V sourceVertex, V targetVertex)
	{
	    return getEdge(sourceVertex, targetVertex) != null;
	}

	/**
	 * Returns a string of the parenthesized pair (V, E) representing this
	 * G=(V,E) graph. 'V' is the string representation of the vertex set, and
	 * 'E' is the string representation of the edge set.
	 *
	 * @return a string representation of this graph.
	 */
	public String toString()
	{
	    return toStringFromSets(
	        vertexSet(),
	        edgeSet(),
	        (this instanceof DirectedMutableGraph<?, ?>));
	}

	/**
	 * Ensures that the specified vertex exists in this graph, or else throws
	 * exception.
	 *
	 * @param v vertex
	 *
	 * @return <code>true</code> if this assertion holds.
	 *
	 * @throws NullPointerException if specified vertex is <code>null</code>.
	 * @throws IllegalArgumentException if specified vertex does not exist in
	 * this graph.
	 */
	protected boolean assertVertexExist(V v)
	{
	    if (containsVertex(v)) {
	        return true;
	    } else if (v == null) {
	        throw new NullPointerException();
	    } else {
	        throw new IllegalArgumentException("no such vertex in graph");
	    }
	}

	/**
	 * Helper for subclass implementations of toString( ).
	 *
	 * @param vertexSet the vertex set V to be printed
	 * @param edgeSet the edge set E to be printed
	 * @param directed true to use parens for each edge (representing directed);
	 * false to use curly braces (representing undirected)
	 *
	 * @return a string representation of (V,E)
	 */
	protected String toStringFromSets(
	    Collection<? extends V> vertexSet,
	    Collection<? extends E> edgeSet,
	    boolean directed)
	{
	    List<String> renderedEdges = new ArrayList<String>();
	
	    StringBuffer sb = new StringBuffer();
	    for (E e : edgeSet) {
	        if ((e.getClass() != DefaultEdge.class)
	            && (e.getClass() != DefaultWeightedEdge.class))
	        {
	            sb.append(e.toString());
	            sb.append("=");
	        }
	        if (directed) {
	            sb.append("(");
	        } else {
	            sb.append("{");
	        }
	        sb.append(getEdgeSource(e));
	        sb.append(",");
	        sb.append(getEdgeTarget(e));
	        if (directed) {
	            sb.append(")");
	        } else {
	            sb.append("}");
	        }
	
	        // REVIEW jvs 29-May-2006:  dump weight somewhere?
	        renderedEdges.add(sb.toString());
	        sb.setLength(0);
	    }
	
	    return "(" + vertexSet + ", " + renderedEdges + ")";
	}

	/**
	 * Returns a hash code value for this graph. The hash code of a graph is
	 * defined to be the sum of the hash codes of vertices and edges in the
	 * graph. It is also based on graph topology and edges weights.
	 *
	 * @return the hash code value this graph
	 *
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
	    int hash = vertexSet().hashCode();
	
	    for (E e : edgeSet()) {
	        int part = e.hashCode();
	
	        int source = getEdgeSource(e).hashCode();
	        int target = getEdgeTarget(e).hashCode();
	
	        // see http://en.wikipedia.org/wiki/Pairing_function (VK);
	        int pairing =
	            ((source + target)
	                * (source + target + 1) / 2) + target;
	        part = (27 * part) + pairing;
	
	        long weight = (long) getEdgeWeight(e);
	        part = (27 * part) + (int) (weight ^ (weight >>> 32));
	
	        hash += part;
	    }
	
	    return hash;
	}

	/**
	 * Indicates whether some other object is "equal to" this graph. Returns
	 * <code>true</code> if the given object is also a graph, the two graphs are
	 * instances of the same graph class, have identical vertices and edges sets
	 * with the same weights.
	 *
	 * @param obj object to be compared for equality with this graph
	 *
	 * @return <code>true</code> if the specified object is equal to this graph
	 *
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object obj)
	{
	    if (this == obj) {
	        return true;
	    }
	    if ((obj == null) || (getClass() != obj.getClass())) {
	        return false;
	    }
	
	    TypeUtil<MutableGraph<V, E>> typeDecl = null;
	    MutableGraph<V, E> g = TypeUtil.uncheckedCast(obj, typeDecl);
	
	    if (!vertexSet().equals(g.vertexSet())) {
	        return false;
	    }
	    if (edgeSet().size() != g.edgeSet().size()) {
	        return false;
	    }
	
	    for (E e : edgeSet()) {
	        V source = getEdgeSource(e);
	        V target = getEdgeTarget(e);
	
	        if (!g.containsEdge(e)) {
	            return false;
	        }
	
	        if (!g.getEdgeSource(e).equals(source)
	            || !g.getEdgeTarget(e).equals(target))
	        {
	            return false;
	        }
	
	        if (Math.abs(getEdgeWeight(e) - g.getEdgeWeight(e)) > 10e-7) {
	            return false;
	        }
	    }
	
	    return true;
	}

}
