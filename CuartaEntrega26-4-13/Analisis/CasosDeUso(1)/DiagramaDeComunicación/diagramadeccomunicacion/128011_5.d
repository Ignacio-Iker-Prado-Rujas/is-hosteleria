format 76

classinstance 128267 class_ref 128514 // Menu
  name ""   xyz 336 4 2000 life_line_z 2000
classinstance 128523 class_ref 128011 // RestauranteSwing
  name ""   xyz 83.3 4 2000 life_line_z 2000
note 129163 "Caso de uso: Ver menu"
  xyzwh 644.7 514.7 2000 94 46
classinstance 131595 class_ref 128130 // Consumicion
  name ""   xyz 505 4 2000 life_line_z 2000
fragment 133259 "loop"
  xyzwh 308.1 189.8 0 275 92
end
textcanvas 134027 "[!listaVacia]"
  xyzwh 368 189 2000 56 14
fragment 134155 "opt"
  xyzwh 87.2 340 0 497 125
end
note 136075 "En este bucle recogemos una lista con los nombres de las consumiciones del tipoConsumicion"
  xyzwh 634.2 44.8 2000 115 101
durationcanvas 128651 classinstance_ref 128523 // :RestauranteSwing
  xyzwh 130 72 2010 11 405
end
durationcanvas 128779 classinstance_ref 128267 // :Menu
  xyzwh 355 75 2010 11 44
end
durationcanvas 129675 classinstance_ref 128267 // :Menu
  xyzwh 355 164 2010 11 144
end
durationcanvas 131723 classinstance_ref 131595 // :Consumicion
  xyzwh 537 192 2010 11 71
end
durationcanvas 135307 classinstance_ref 128267 // :Menu
  xyzwh 355 360 2010 11 82
end
durationcanvas 135563 classinstance_ref 131595 // :Consumicion
  xyzwh 537 378 2010 11 43
end
msg 128907 asynchronous
  from durationcanvas_ref 128651
  to durationcanvas_ref 128779
  yz 78 2015 msg operation_ref 128523 // "verMenu()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 297 66
msg 129035 return
  from durationcanvas_ref 128779
  to durationcanvas_ref 128651
  yz 109 2020 explicitmsg "tipoConsumiciones"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 150 100
msg 129803 synchronous
  from durationcanvas_ref 128651
  to durationcanvas_ref 129675
  yz 164 2015 explicitmsg "mostrarPlatos(tipoConsumicion)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 200 153
msg 130571 return
  from durationcanvas_ref 129675
  to durationcanvas_ref 128651
  yz 297 2015 explicitmsg "nombresConsumiciones"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 149 286
msg 131851 synchronous
  from durationcanvas_ref 129675
  to durationcanvas_ref 131723
  yz 225 2015 msg operation_ref 128139 // "getNombre()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 475 213
msg 131979 return
  from durationcanvas_ref 131723
  to durationcanvas_ref 129675
  yz 252 2015 explicitmsg "nombre"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 374 242
msg 135435 synchronous
  from durationcanvas_ref 128651
  to durationcanvas_ref 135307
  yz 361 2015 explicitmsg "describeConsumicion(Consumicion)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 179 349
msg 135691 synchronous
  from durationcanvas_ref 135307
  to durationcanvas_ref 135563
  yz 380 2015 msg operation_ref 128395 // "getDescripcion()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 461 367
msg 135819 return
  from durationcanvas_ref 135563
  to durationcanvas_ref 135307
  yz 410 2015 explicitmsg "descripcion"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 370 400
msg 135947 return
  from durationcanvas_ref 135307
  to durationcanvas_ref 128651
  yz 423 2015 explicitmsg "descripcion"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 219 410
line 136843 -_-_
  from ref 136075 z 2001 to ref 133259
end
