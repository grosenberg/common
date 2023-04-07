package net.certiv.common.graph.demo;

import java.util.Map;

import net.certiv.common.graph.Edge.Sense;
import net.certiv.common.graph.EdgeSet;
import net.certiv.common.graph.Node;
import net.certiv.common.graph.Walker.NodeVisitor;
import net.certiv.common.stores.LinkedHashList;

public class DemoNode extends Node<DemoNode, DemoEdge> {

	public final DemoGraph graph;

	public DemoNode(DemoGraph graph, EdgeSet<DemoNode, DemoEdge> in, EdgeSet<DemoNode, DemoEdge> out) {
		super(in, out);
		this.graph = graph;
	}

	public DemoNode(DemoGraph graph, EdgeSet<DemoNode, DemoEdge> in, EdgeSet<DemoNode, DemoEdge> out,
			String name) {
		this(graph, in, out);
		if (!name.isBlank()) put(NODE_NAME, name);
	}

	public DemoNode(DemoGraph graph, EdgeSet<DemoNode, DemoEdge> in, EdgeSet<DemoNode, DemoEdge> out,
			Map<Object, Object> props) {
		this(graph, in, out);
		putAll(props);
	}

	public Long id() {
		return _nid;
	}

	@Override
	public boolean enter(Sense dir, LinkedHashList<DemoNode, DemoNode> visited,
			NodeVisitor<DemoNode> listener, DemoNode parent) {
		return listener.enter(dir, visited, parent, this);
	}

	@Override
	public boolean exit(Sense dir, LinkedHashList<DemoNode, DemoNode> visited, NodeVisitor<DemoNode> listener,
			DemoNode parent) {
		return listener.exit(dir, visited, parent, this);
	}
}
