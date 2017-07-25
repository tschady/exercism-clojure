(ns robot-name)

(def all-names
  (let [alpha "ABCDEFGHIJKLMNOPQRSTUVWXYZ"]
    (shuffle (for [x (seq alpha) y (seq alpha) n (range 1000)]
               (str x y (format "%03d" n))))))

(def pointer (atom -1))

(defn- next-available-name []
  (when (< (swap! pointer inc) (count all-names))
      (nth all-names @pointer)))

(defn robot [] (atom (next-available-name)))

(def robot-name deref)

(defn reset-name [r] (reset! r (next-available-name)))
