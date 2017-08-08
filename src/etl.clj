(ns etl
  (:require [clojure.string :as str]))

(defn transform
  "Transform legacy data format to new format.
  e.g.  Old:  {1 ['A' 'E']} ==> New: {'a' 1 'e' 1}"
  [old-map]
  (reduce-kv (fn [m k v] (into m (zipmap (map str/lower-case v) (repeat k))))
             {} old-map))
