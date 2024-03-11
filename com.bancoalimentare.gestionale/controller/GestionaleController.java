package com.bancoalimentare.gestionale.controller;

import com.bancoalimentare.gestionale.service.GestionaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/rest/api/v0")
public class GestionaleController
{
    @Autowired
    GestionaleService gestionaleService;

    /**************************************************/
    /*                      ZONE                      */
    /**************************************************/



    /**************************************************/
    /*                    FAMIGLIA                    */
    /**************************************************/



    /**************************************************/
    /*                    REFERENTE                 */
    /**************************************************/



    /**************************************************/
    /*                   DISTRIBUZIONE                */
    /**************************************************/



    /**************************************************/
    /*                      PRODOTTO                  */
    /**************************************************/





}