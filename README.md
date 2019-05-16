# Load-calculation

This project aim is to calculate the load on each vertex in an undirected graph.

Load is defined as: 

Let G = <V, E> be an undirected graph. Let X ∈ V. 

Load(X) = 

   for each A in V
 
       for each B (not equal to X) in V
  
             Number of shortest paths from A to B that pass through X / Numer of shortest paths from A to B. 
