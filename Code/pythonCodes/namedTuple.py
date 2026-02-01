from collections import namedtuple

point = namedtuple('Point', ['x', 'y'])
p = point(11, 22)
print(p.x, p.y)

from collections import deque
d = deque([2,4,5,2,7])
print(d)
d.popleft()
print(d)

# Counter
from collections import Counter
str = "ADITYA"
list_str = list(str)
print(list_str)
count_char = Counter(list_str)
print(count_char)

