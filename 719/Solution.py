from typing import List
import bisect 

class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        bisect_left = bisect.bisect_left(range(nums[-1] - nums[0]), k, lo=count)
        def count(mid: int) -> int:
            cnt = 0
            for j, num in enumerate(nums):
                i = bisect_left(nums, num - mid, 0, j)
                cnt += j - i
            return cnt

        nums.sort()
        return bisect_left(range(nums[-1] - nums[0]), k, lo=count)

s = Solution()
s.smallestDistancePair([1,2,3],1)
# 作者：LeetCode-Solution
# 链接：https://leetcode.cn/problems/find-k-th-smallest-pair-distance/solution/zhao-chu-di-k-xiao-de-shu-dui-ju-chi-by-xwfgf/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。