    import { ReactFlow, Controls, Background, useNodesState, useEdgesState, addEdge } from '@xyflow/react';
    import '@xyflow/react/dist/style.css'; // Import the default styles

    const initialNodes = [
      { id: '1', position: { x: 0, y: 0 }, data: { label: 'Node 1' } },
      { id: '2', position: { x: 100, y: 100 }, data: { label: 'Node 2' } },
    ];

    const initialEdges = [{ id: 'e1-2', source: '1', target: '2' }];

    function App() {
      const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);
      const [edges, setEdges, onEdgesChange] = useEdgesState(initialEdges);

      const onConnect = (params) => setEdges((eds) => addEdge(params, eds));

      return (
        <div style={{ width: '100vw', height: '100vh' }}>
          <ReactFlow
            nodes={nodes}
            edges={edges}
            onNodesChange={onNodesChange}
            onEdgesChange={onEdgesChange}
            onConnect={onConnect}
            fitView
          >
            <Controls />
            <Background variant="dots" gap={12} size={1} />
          </ReactFlow>
        </div>
      );
    }

    export default App;