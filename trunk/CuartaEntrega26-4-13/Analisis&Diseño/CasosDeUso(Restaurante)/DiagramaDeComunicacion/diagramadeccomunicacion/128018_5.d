format 76

classinstance 128274 class_ref 128770 // Reserva
 name ""  xyz 304 221 2000
classinstance 128402 class_ref 128146 // ListaReserva
 name ""  xyz 295 48 2000
linkcanvas 128658
  from ref 128274 z 2001 to ref 128402
dirscanvas 129810 z 1000 linkcanvas_ref 128658
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 modifica" xyz 259 145 3000
linkcanvas 129938
  from ref 128402 z 2001 to ref 128274
dirscanvas 130066 z 1000 linkcanvas_ref 129938
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "2 modifica" xyz 348 146 3000
msgs
  explicitmsg "modifica"
    forward ranks 1 "1" dirscanvas_ref 129810
    msgs
      explicitmsg "modifica"
	forward ranks 2 "1.1" dirscanvas_ref 130066
	no_msg
    msgsend
msgsend
end
