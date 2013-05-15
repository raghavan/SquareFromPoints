python kde.py -p trips/trips_1m/
python skeleton.py kde.png skeleton.png
python graph_extract.py skeleton.png bounding_boxes/bounding_box_1m.txt skeleton_maps/skeleton_map_1m.db
python graphdb_matcher_run.py -d skeleton_maps/skeleton_map_1m.db -t trips/trips_1m/ -o trips/matched_trips_1m/
python process_map_matches.py -d skeleton_maps/skeleton_map_1m.db -t trips/matched_trips_1m/ -o skeleton_maps/skeleton_map_1m_mm1.db
python refine_topology.py -d skeleton_maps/skeleton_map_1m_mm1.db -t skeleton_maps/skeleton_map_1m_mm1_traces.txt -o skeleton_maps/skeleton_map_1m_mm1_tr.db
python graphdb_matcher_run.py -d skeleton_maps/skeleton_map_1m_mm1_tr.db -t trips/trips_1m/ -o trips/matched_trips_1m_mm1_tr/
python process_map_matches.py -d skeleton_maps/skeleton_map_1m_mm1_tr.db -t trips/matched_trips_1m_mm1_tr/ -o skeleton_maps/skeleton_map_1m_mm2.db
python streetmap.py graphdb skeleton_maps/skeleton_map_1m_mm2.db final_map.txt
