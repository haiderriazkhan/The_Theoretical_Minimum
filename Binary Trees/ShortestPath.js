"use strict";

// BFS based implementation to determine the shortest path between two nodes in an undirected graph
// inputs:  list of edges [[0, 5], [1,2], [3,2], [5,1], [6,3], [7]], source node, target node
function shortestPath(edgeList, sourceNodeID, targetNodeID) {
    // Get all the unique nodes in the graph
    const nodesList = new Set(edgeList.flat());
    const visited = new Set();
    const adjList = new Map();
    const distance = new Map();


    for (const node of edgeList) {
        if (node.length === 1) {
            continue;
        }
        if (!adjList.has(node[0])) {
            adjList.set(node[0], []);
        }
        if (!adjList.has(node[1])) {
            adjList.set(node[1], []);
        }
        adjList.get(node[0]).push(node[1]);
        adjList.get(node[1]).push(node[0]);
    }

    // start from the source node
   distance.set(sourceNodeID, 0);
   visited.add(sourceNodeID);

    const queue = [];
    queue.push(sourceNodeID);

    while (queue.length > 0 ) {
        const node = queue.shift();
        const nodeDistance = distance.get(node);
        const neighbors = adjList.get(node) || [];
        for (const neighbor of neighbors) {
            if (!visited.has(neighbor)) {
                visited.add(neighbor);
                distance.set(neighbor, nodeDistance + 1);
                queue.push(neighbor);
            }
        }
    }
    return distance.get(targetNodeID) ?? -1;
}

const edgeList = [[1,2], [6,4], [1,3], [1,5], [2, 6], [5,3], [0]];

console.log(shortestPath(edgeList, 3, 5));
