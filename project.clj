(defproject hyperdimentional-computing "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]  [net.mikera/core.matrix "0.49.0"] [net.mikera/vectorz-clj "0.43.1"]]
  :main ^:skip-aot hyperdimentional-computing.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
