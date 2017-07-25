(ns grains)

(defn square [n] (.pow (biginteger 2) (dec n)))

(defn total [] (reduce + (map square (range 1 65))))
