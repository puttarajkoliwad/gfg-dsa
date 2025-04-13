# nc4, lc49, https://leetcode.com/problems/group-anagrams/description/

# time complexity: O(n*k), k => length of largest string
# space complexity: O(n*k)

def group_anagrams(strs)
  h1 = {}
  
  strs.each do |str|
    key = anagram_key(str)

    if h1[key]
      h1[key] << str
    else
      h1[key] = [str]
    end
  end

  h1.values
end

def anagram_key(str)
  a = 'a'.ord
  arr = Array.new(26, 0)

  str.each_char do |c|
    arr[c.ord - a] += 1
  end

  arr.join(",")
end