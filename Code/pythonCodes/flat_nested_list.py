# class FlatNestedList:
#     def __init__(self, nested_list):
#         self.nested_list = nested_list
#         self.flat_list = self._flatten(nested_list)
#         self.index = 0

#     def _flatten(self, lst):
#         flat_list = []
#         for item in lst:
#             if isinstance(item, list):
#                 flat_list.extend(self._flatten(item))
#             else:
#                 flat_list.append(item)
#         return flat_list

#     def __iter__(self):
#         return self

#     def __next__(self):
#         if self.index < len(self.flat_list):
#             result = self.flat_list[self.index]
#             self.index += 1
#             return result
#         else:
#             raise StopIteration
        
# nested_list = [[1, 2, [3]], 4, [5, 6], 7, [8, [9, 10]]]
# flat_list_iterator = FlatNestedList(nested_list)
# print(list(flat_list_iterator))
# # Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# # Generator-based Implementation

def flat_generator(nested_list):
    for item in nested_list:
        if isinstance(item, list):
            yield from flat_generator(item)
        else:
            yield item

nested_list = [[1, 2, [3]], 4, [5, 6], 7, [8, [9, 10]]]
flat_list = list(flat_generator(nested_list))
print(flat_list)
# Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]