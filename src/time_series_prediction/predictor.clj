(ns time-series-prediction.predictor
  #_(:require ))

(defn constant-prediction
  "And the number of the counting shall be three!"
  [histogram time]
  3)

(defn mean-prediction
  "Simple average."
  [histogram time]
  (let [freqs (vals histogram)
        sum (reduce + 0.0 freqs)
        len (count freqs)]
    (/ sum len)))
