# nc5, lc347, https://leetcode.com/problems/top-k-frequent-elements/description/

# time complexity: O(Nlog(k))
# space complexity: O(N)

require 'algorithms'

def top_k_frequent(nums, k)
  return nums if nums.length == k

  h1 = nums.tally
  pq = Containers::PriorityQueue.new

  h1.each do |k, v|
    pq.push k, v
    # pq.pop if pq.size > k
  end

  res = []
  k.times do
    res << pq.pop
  end

  res
end