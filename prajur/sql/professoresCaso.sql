﻿select * from professor p, caso c, caso_com_professor cp where p.codigo = cp.professor_id and c.codigo = cp.caso_id 