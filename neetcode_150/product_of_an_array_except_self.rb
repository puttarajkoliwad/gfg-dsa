# nc6, lc238, https://leetcode.com/problems/product-of-array-except-self/description/

# time complexity: O(n)
# space complexity: O(1)

def product_except_self(nums)
  prefix = nums.first
  suffix = nums.last

  res = [1]

  # prefix run
  for i in 1...nums.length
    res << prefix
    prefix *= nums[i]
  end

  # suffix run
  (nums.length - 2).downto(0) do |ind|
    res[ind] *= suffix
    suffix *= nums[ind]
  end

  res
end