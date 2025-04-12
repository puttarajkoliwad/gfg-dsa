# nc2, lc242, https://leetcode.com/problems/valid-anagram/description/

# time complexity: O(n)
# space complexity: O(1)

def is_anagram(s, t)
  return false if s.length != t.length

  a = 'a'.ord
  arr = Array.new(26, 0)

  for i in 0...s.length
    arr[s[i].ord - a] += 1
    arr[t[i].ord - a] -= 1
  end

  arr.each do |num|
    return false if num != 0
  end

  true
end