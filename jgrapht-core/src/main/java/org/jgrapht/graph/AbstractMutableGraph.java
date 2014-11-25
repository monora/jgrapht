/* ==========================================
 * JGraphT : a free Java graph-theory library
 * ==========================================
 *
 * Project Info:  http://jgrapht.sourceforge.net/
 * Project Creator:  Barak Naveh (http://sourceforge.net/users/barak_naveh)
 *
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */
/* ------------------
 * AbstractGraph.java
 * ------------------
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * Original Author:  Barak Naveh
 * Contributor(s):   Christian Hammer
 *                   Vladimir Kostyukov
 *
 * $Id$
 *
 * Changes
 * -------
 * 24-Jul-2003 : Initial revision (BN);
 * 11-Mar-2004 : Made generic (CH);
 * 07-May-2006 : Changed from List<Edge> to Set<Edge> (JVS);
 * 28-May-2006 : Moved connectivity info from edge to graph (JVS);
 * 14-Jun-2012 : Added hashCode() and equals() methods implementation (VK);
 *
 */
package org.jgrapht.graph;

import java.util.Collection;
import java.util.Set;

import org.jgrapht.DirectedMutableGraph;
import org.jgrapht.MutableGraph;
import org.jgrapht.UndirectedMutableGraph;


/**
 * A skeletal implementation of the <tt>Graph</tt> interface, to minimize the
 * effort required to implement graph interfaces. This implementation is
 * applicable to both: directed graphs and undirected graphs.
 *
 * @author Barak Naveh
 * @see MutableGraph
 * @see DirectedMutableGraph
 * @see UndirectedMutableGraph
 */
public abstract class AbstractMutableGraph<V, E> extends AbstractGraph<V,E>
    implements MutableGraph<V, E>
{
    

    /**
     * Construct a new empty graph object.
     */
    public AbstractMutableGraph()
    {
    }

    

    /**
	 * @see MutableGraph#removeAllEdges(Collection)
	 */
	public boolean removeAllEdges(Collection<? extends E> edges)
	{
	    boolean modified = false;
	
	    for (E e : edges) {
	        modified |= removeEdge(e);
	    }
	
	    return modified;
	}



	/**
	 * @see MutableGraph#removeAllEdges(Object, Object)
	 */
	public Set<E> removeAllEdges(V sourceVertex, V targetVertex)
	{
	    Set<E> removed = getAllEdges(sourceVertex, targetVertex);
	    if (removed == null) {
	        return null;
	    }
	    removeAllEdges(removed);
	
	    return removed;
	}



	/**
	 * @see MutableGraph#removeAllVertices(Collection)
	 */
	public boolean removeAllVertices(Collection<? extends V> vertices)
	{
	    boolean modified = false;
	
	    for (V v : vertices) {
	        modified |= removeVertex(v);
	    }
	
	    return modified;
	}



	/**
	 * Removes all the edges in this graph that are also contained in the
	 * specified edge array. After this call returns, this graph will contain no
	 * edges in common with the specified edges. This method will invoke the
	 * {@link MutableGraph#removeEdge(Object)} method.
	 *
	 * @param edges edges to be removed from this graph.
	 *
	 * @return <tt>true</tt> if this graph changed as a result of the call.
	 *
	 * @see MutableGraph#removeEdge(Object)
	 * @see MutableGraph#containsEdge(Object)
	 */
	protected boolean removeAllEdges(E [] edges)
	{
	    boolean modified = false;
	
	    for (int i = 0; i < edges.length; i++) {
	        modified |= removeEdge(edges[i]);
	    }
	
	    return modified;
	}
}

// End AbstractGraph.java
