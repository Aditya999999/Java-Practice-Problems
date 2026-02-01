my_set = {1,2,3,4,5,5,5}
print(my_set)
my_set.add(9)
print(my_set)
my_set.remove(5)
print(my_set)

my_frozen_set = frozenset([1,2.4,2,2,3])
print(my_frozen_set)
my_frozen_set_union = my_frozen_set.union(frozenset([3,545,78]))
print(my_frozen_set_union)