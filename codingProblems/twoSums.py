nums = [2,7,11,15]
target = 9


numMap = {}
n = len(nums)

for i in range(n):
    complement = target - nums[i]
    if complement in numMap:
        print ([numMap[complement], i])
    numMap[nums[i]] = i
        
        
