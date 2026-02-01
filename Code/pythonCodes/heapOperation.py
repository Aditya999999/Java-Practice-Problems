import heapq

heap = []
# Insertion
heapq.heappush(heap, 10)
heapq.heappush(heap, 9)
heapq.heappush(heap, 8)
print(heap)

# Deletion
heapq.heappop(heap) # pop only takes heap as argument and deletes first value
print(heap)

# Heapify
array = [12,432,6546,7657,342, 423, 897]

heapq.heapify(array)
print(array)