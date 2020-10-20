import sys
# adjancency list of graph
graph = {
    'A': [['B', 'C'], ['D']],
    'B': [['G'], ['H']],
    'D': [['E', 'F']]
}

# cost of each node
node_cost = {
    'B': 6, 'C': 12, 'D': 10, 'E': 4, 'F': 4, 'G': 4, 'H': 7
}

# given edge cost
edge_cost = 1
# root node
head_node = ['A']


def solve(nodes):
    flag = 0
    for node in nodes:
        if node in graph.keys():
            # go through the children of the node
            flag = 1
    # reached leaf nodes / end
    if not flag:
        return 0

    min_cost = sys.maxsize

    for node in nodes:
        if node in graph.keys():
            # depth wise search of the node to calculate the cost
            for path in graph[node]:
                cost = 0
                for node in path:
        # sum of node cost and edge cost to calculate the final heuristic value of the node
                    cost += node_cost[node] + edge_cost
                if min_cost > cost:
                    min_cost = cost
                    next_nodes = path

    print(next_nodes,min_cost)
    return [next_nodes, min_cost]


def driver():
    cost = 0
    nodes = head_node
    moves = 0
    while 1:
        for node in nodes:
            result = solve(node)
            if not result:
                print("moves:", moves)
                print("cost:", cost)
                return cost
            cost = cost + result[1]
            nodes = result[0]
        moves = moves + 1


if __name__ == "__main__":
    driver()