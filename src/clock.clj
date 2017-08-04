(ns clock)
(defn clock
  "Return clock (a tuple of [hours minutes]) from given number of
  hours and minutes.  Either input can be negative."
  [h m]
  (let [minute-overflow (Math/floorDiv m 60)
        minutes (mod m 60)
        hours (mod (+ h minute-overflow) 24)]
    [hours minutes]))

(defn add-time
  "Returns new clock with minutes added (can be negative)"
  [[h m] add-mins]
  (clock h (+ m add-mins)))

(defn clock->string
  "Human readable string for 24-hour clock"
  [[h m]]
  (format "%02d:%02d" h m))
