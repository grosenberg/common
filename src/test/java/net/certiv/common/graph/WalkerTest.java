package net.certiv.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.certiv.common.graph.Edge.Sense;
import net.certiv.common.graph.Walker.NodeVisitor;
import net.certiv.common.graph.demo.DemoEdge;
import net.certiv.common.graph.demo.DemoNode;
import net.certiv.common.stores.LinkedHashList;
import net.certiv.common.stores.UniqueList;

class WalkerTest extends TestGraphBase {

	static final boolean FORCE = true;
	private DemoNode root;

	@BeforeEach
	void setUp() {
		builder.createAndAddEdges("A->B->C->D->E");
		builder.createAndAddEdges("C->F->G");
		builder.createAndAddEdges("D->H->I->J");

		root = builder.getNode("A");
	}

	@Test
	void testFullWalk() {
		graph.put(Graph.GRAPH_NAME, "Walker");

		Walker<DemoNode, DemoEdge> w = graph.walker();
		w.descend(new Vis("X", "Y", "Z"), root);
		UniqueList<DemoNode> v = new UniqueList<>(w.visited().valuesAll());
		assertEquals(10, v.size());
	}

	@Test
	void testWalkRet() {
		graph.put(Graph.GRAPH_NAME, "Walker");

		Walker<DemoNode, DemoEdge> w = graph.walker();
		w.descend(new Vis("D", "Y", "Z"), root);
		UniqueList<DemoNode> v = new UniqueList<>(w.visited().valuesAll());
		assertEquals(6, v.size());
	}

	@Test
	void testWalkDone() {
		graph.put(Graph.GRAPH_NAME, "Walker");

		Vis vis = new Vis("X", "D", "Z");
		graph.walker().descend(vis, root);
		assertEquals(4, vis.entered.size());
		assertEquals(4, vis.exited.size());
	}

	@Test
	void testWalkStop() {
		graph.put(Graph.GRAPH_NAME, "Walker");

		Vis vis = new Vis("X", "Y", "D");
		graph.walker().descend(vis, root);
		assertEquals(4, vis.entered.size());
		assertEquals(0, vis.exited.size());
	}

	private final class Vis extends NodeVisitor<DemoNode> {
		private final LinkedHashSet<DemoNode> entered = new LinkedHashSet<>();
		private final LinkedHashSet<DemoNode> exited = new LinkedHashSet<>();

		private final String retnName;
		private final String doneName;
		private final String stopName;

		public Vis(String retnName, String doneName, String stopName) {
			this.retnName = retnName;
			this.doneName = doneName;
			this.stopName = stopName;
		}

		@Override
		public boolean enter(Sense dir, LinkedHashList<DemoNode, DemoNode> visited, DemoNode prev,
				DemoNode node) {

			entered.add(node);

			String name = node.name();
			if (name.equals(doneName)) done();
			if (name.equals(stopName)) stop();
			return !name.equals(retnName);
		}

		@Override
		public boolean exit(Sense dir, LinkedHashList<DemoNode, DemoNode> visited, DemoNode prev,
				DemoNode node) {
			exited.add(node);
			return true;
		}
	}
}
