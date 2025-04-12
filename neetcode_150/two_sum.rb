# nc3, lc1, https://leetcode.com/problems/two-sum/description/

# time complexity: O(n)
# space complexity: O(n)

def two_sum(nums, target)
  h = {}
  nums.each_with_index do |num, ind|
    return [ind, h1[target-num]] if h.has_key? target - num
    h1[num] = ind
  end
end