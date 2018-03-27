package com.mmanrique.distributed.apps.main.ui

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {


  @GetMapping
  def getIndexPage(model:Model):String = {
    "index"
  }

}
