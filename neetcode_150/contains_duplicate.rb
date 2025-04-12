# https://leetcode.com/problems/contains-duplicate/description/

def contains_duplicates(nums)
  s = Set.new([])

  nums.each do |num|
    return false if s.include? num
    s.add num
  end

  false
end