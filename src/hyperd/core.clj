(ns hyperd.core
  (:require [clojure.core.matrix :as m]
        [clojure.core.matrix.linear :as ml]
        (:gen-class)))


(m/set-current-implementation :vectorz)

(def sz 100000)

(defn rand-hv []
  (let [hv (m/new-sparse-array [sz])
        n (* 0.1 sz)]
    (dotimes [i n]
      (m/mset! hv (rand-int sz) 1))
    hv))

(defn cosine-sim [v1 v2]
  (/ (m/dot v1 v2)
     (* (ml/norm v1) (ml/norm v2))))

(defn mean-add [& hvs]
  (m/emap #(Math/round (double %))
   (m/div (apply m/add hvs) (count hvs))))

(defn xor-mul [v1 v2]
  (->> (m/add v1 v2)
      (m/emap #(mod % 2))))

(defn hamming-dist [v1 v2]
  (m/esum (xor-mul v1 v2)))

(def a (rand-hv))
(def b (rand-hv))
(println (cosine-sim a b))


(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hyperdimentional Computing Experiments!"))
