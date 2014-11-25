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
/* -------------------
 * GraphDelegator.java
 * -------------------
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * Original Author:  Barak Naveh
 * Contributor(s):   Christian Hammer
 *
 * $Id$
 *
 * Changes
 * -------
 * 24-Jul-2003 : Initial revision (BN);
 * 11-Mar-2004 : Made generic (CH);
 * 07-May-2006 : Changed from List<Edge> to Set<Edge> (JVS);
 * 28-May-2006 : Moved connectivity info from edge to graph (JVS);
 *
 */
package org.jgrapht.graph;

import java.io.*;

import java.util.*;

import org.jgrapht.*;


/**
 * A graph backed by the the graph specified at the constructor, which delegates
 * all its methods to the backing graph. Operations on this graph "pass through"
 * to the to the backing graph. Any modification made to this graph or the
 * backing graph is reflected by the other.
 *
 * <p>This graph does <i>not</i> pass the hashCode and equals operations through
 * to the backing graph, but relies on <tt>Object</tt>'s <tt>equals</tt> and
 * <tt>hashCode</tt> methods.</p>
 *
 * <p>This class is mostly used as a base for extending subclasses.</p>
 *
 * @author Barak Naveh
 * @since Jul 20, 2003
 */
public class GraphDelegator<V, E>
    extends AbstractMutableGraph<V, E>
    implements MutableGraph<V, E>,
        Serializable
{
    

    private static final long serialVersionUID = 3257005445226181425L;

    

    /**
     * The graph to which operations are delegated.
     */
    private MutableGraph<V, E> delegate;

    

    /**
     * Constructor for GraphDelegator.
     *
     * @param g the backing graph (the delegate).
     *
     * @throws IllegalArgumentException iff <code>g==null</code>
     */
    public GraphDelegator(MutableGraph<V, E> g)
    {
        super();

        if (g == null) {
            throw new IllegalArgumentException("g must not be null.");
        }

        delegate = g;
    }

    

    /**
     * @see MutableGraph#getAllEdges(Object, Object)
     */
    public Set<E> getAllEdges(V sourceVertex, V targetVertex)
    {
        return delegate.getAllEdges(sourceVertex, targetVertex);
    }

    /**
     * @see MutableGraph#getEdge(Object, Object)
     */
    public E getEdge(V sourceVertex, V targetVertex)
    {
        return delegate.getEdge(sourceVertex, targetVertex);
    }

    /**
     * @see MutableGraph#getEdgeFactory()
     */
    public EdgeFactory<V, E> getEdgeFactory()
    {
        return delegate.getEdgeFactory();
    }

    /**
     * @see MutableGraph#addEdge(Object, Object)
     */
    public E addEdge(V sourceVertex, V targetVertex)
    {
        return delegate.addEdge(sourceVertex, targetVertex);
    }

    /**
     * @see MutableGraph#addEdge(Object, Object, Object)
     */
    public boolean addEdge(V sourceVertex, V targetVertex, E e)
    {
        return delegate.addEdge(sourceVertex, targetVertex, e);
    }

    /**
     * @see MutableGraph#addVertex(Object)
     */
    public boolean addVertex(V v)
    {
        return delegate.addVertex(v);
    }

    /**
     * @see MutableGraph#containsEdge(Object)
     */
    public boolean containsEdge(E e)
    {
        return delegate.containsEdge(e);
    }

    /**
     * @see MutableGraph#containsVertex(Object)
     */
    public boolean containsVertex(V v)
    {
        return delegate.containsVertex(v);
    }

    /**
     * @see UndirectedMutableGraph#degreeOf(Object)
     */
    public int degreeOf(V vertex)
    {
        return ((UndirectedMutableGraph<V, E>) delegate).degreeOf(vertex);
    }

    /**
     * @see MutableGraph#edgeSet()
     */
    public Set<E> edgeSet()
    {
        return delegate.edgeSet();
    }

    /**
     * @see MutableGraph#edgesOf(Object)
     */
    public Set<E> edgesOf(V vertex)
    {
        return delegate.edgesOf(vertex);
    }

    /**
     * @see DirectedMutableGraph#inDegreeOf(Object)
     */
    public int inDegreeOf(V vertex)
    {
        return ((DirectedMutableGraph<V, ? extends E>) delegate).inDegreeOf(vertex);
    }

    /**
     * @see DirectedMutableGraph#incomingEdgesOf(Object)
     */
    public Set<E> incomingEdgesOf(V vertex)
    {
        return ((DirectedMutableGraph<V, E>) delegate).incomingEdgesOf(vertex);
    }

    /**
     * @see DirectedMutableGraph#outDegreeOf(Object)
     */
    public int outDegreeOf(V vertex)
    {
        return ((DirectedMutableGraph<V, ? extends E>) delegate).outDegreeOf(vertex);
    }

    /**
     * @see DirectedMutableGraph#outgoingEdgesOf(Object)
     */
    public Set<E> outgoingEdgesOf(V vertex)
    {
        return ((DirectedMutableGraph<V, E>) delegate).outgoingEdgesOf(vertex);
    }

    /**
     * @see MutableGraph#removeEdge(Object)
     */
    public boolean removeEdge(E e)
    {
        return delegate.removeEdge(e);
    }

    /**
     * @see MutableGraph#removeEdge(Object, Object)
     */
    public E removeEdge(V sourceVertex, V targetVertex)
    {
        return delegate.removeEdge(sourceVertex, targetVertex);
    }

    /**
     * @see MutableGraph#removeVertex(Object)
     */
    public boolean removeVertex(V v)
    {
        return delegate.removeVertex(v);
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return delegate.toString();
    }

    /**
     * @see MutableGraph#vertexSet()
     */
    public Set<V> vertexSet()
    {
        return delegate.vertexSet();
    }

    /**
     * @see MutableGraph#getEdgeSource(Object)
     */
    public V getEdgeSource(E e)
    {
        return delegate.getEdgeSource(e);
    }

    /**
     * @see MutableGraph#getEdgeTarget(Object)
     */
    public V getEdgeTarget(E e)
    {
        return delegate.getEdgeTarget(e);
    }

    /**
     * @see MutableGraph#getEdgeWeight(Object)
     */
    public double getEdgeWeight(E e)
    {
        return delegate.getEdgeWeight(e);
    }

    /**
     * @see WeightedGraph#setEdgeWeight(Object, double)
     */
    public void setEdgeWeight(E e, double weight)
    {
        ((WeightedGraph<V, E>) delegate).setEdgeWeight(e, weight);
    }
}

// End GraphDelegator.java
