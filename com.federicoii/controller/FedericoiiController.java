package universita.federicoii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universita.federicoii.dto.*;
import universita.federicoii.service.FedericoiiService;
import java.util.List;

@RestController
@RequestMapping (value = "/rest/api/v0")
public class FedericoiiController
{

    @Autowired
    FedericoiiService federicoiiService;

    /* ***************************************************************** */
    /*                              CORSO                                */
    /* ***************************************************************** */

    @GetMapping ( value = "/getCorsi" )
    public List<CorsoDTO> getCorsi ()
    {
        return federicoiiService.getCorsi();
    }

    @GetMapping ( value = "/getCorsiDocenti" )
    public List<CorsoConDocenteDTO> getCorsiDocenti ()
    {
        return federicoiiService.getCorsiDocenti();
    }

    @GetMapping ( value = "/getCorsiStudenti" )
    public List<CorsoConStudentiDTO> getCorsiStudenti ()
    {
        return federicoiiService.getCorsiStudenti();
    }

    @GetMapping ( value = "/getCorsoByNome/{nome}" )
    public ResponseEntity<?> getCorsoByNome (@PathVariable String nome)
    {
        if( nome == null || nome.isEmpty() || nome == " " || nome.equals("") || nome.equals(":nome") )
        {
            return new ResponseEntity<>( "ERRORE: il nome del corso di laurea non può essere nullo!", HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>(federicoiiService.getCorsoByNome(nome), HttpStatus.FOUND);
        }
    }

    @PostMapping ( value="/insertNuovoCorso/" )
    public CorsoDTO insertNuovoCorso (@RequestBody CorsoDTO nuovoCorso)
    {
        return federicoiiService.insertNuovoCorso(nuovoCorso);
    }

    /* ***************************************************************** */
    /*                             DOCENTE                               */
    /* ***************************************************************** */

    @GetMapping ( value = "/getDocenti" )
    public List<DocenteDTO> getDocenti ()
    {
        return federicoiiService.getDocenti();
    }

    @GetMapping ( value = "/getDocentiCorso" )
    public List<DocenteConCorsoDTO> getDocentiCorso ()
    {
        return federicoiiService.getDocentiCorso();
    }

    @GetMapping( value = "/getVerificaDocenteResponsabileCorso/{codiceFiscale}" )
    public String getVerificaDocenteResponsabileCorso (@PathVariable String codiceFiscale)
    {
        if( codiceFiscale == null || codiceFiscale.isEmpty() )
        {
            return null;
        }

        return federicoiiService.getVerificaDocenteResponsabileCorso(codiceFiscale);
    }

    @PostMapping ( value="/insertNuovoDocente/" )
    public DocenteDTO insertNuovoDocente (@RequestBody DocenteDTO nuovoDocente)
    {
        return federicoiiService.insertNuovoDocente(nuovoDocente);
    }

    @PostMapping ( value="/assegnareDocenteCorso/{codiceFiscale}/{nomeCorso}" )
    public String assegnareDocenteCorso (@PathVariable String codiceFiscale, @PathVariable String nomeCorso)
    {
        if( codiceFiscale == null || codiceFiscale.isEmpty() || codiceFiscale == " " || codiceFiscale.equals("") || codiceFiscale.equals(":codiceFiscale") )
        {
            return "Il codice fiscale non può essere nullo!";
        }
        else if ( nomeCorso == null || nomeCorso.isEmpty() || nomeCorso == " " || nomeCorso.equals("") || nomeCorso.equals(":nomeCorso") )
        {
            return "Il nome del corso non può essere nullo!";
        }
        else
        {
            return federicoiiService.assegnareDocenteCorso(codiceFiscale, nomeCorso);
        }
    }

    @PostMapping ( value="/cancellareAssegnazioneDocenteCorso/{codiceFiscale}/{nomeCorso}" )
    public String cancellareAssegnazioneDocenteCorso (@PathVariable String codiceFiscale, @PathVariable String nomeCorso)
    {
        if( codiceFiscale == null || codiceFiscale.isEmpty() || codiceFiscale == " " || codiceFiscale.equals("") || codiceFiscale.equals(":codiceFiscale") )
        {
            return "Il codice fiscale non può essere nullo!";
        }
        else if ( nomeCorso == null || nomeCorso.isEmpty() || nomeCorso == " " || nomeCorso.equals("") || nomeCorso.equals(":nomeCorso") )
        {
            return "Il nome del corso non può essere nullo!";
        }
        else
        {
            return federicoiiService.cancellareAssegnazioneDocenteCorso(codiceFiscale, nomeCorso);
        }
    }

    /* ***************************************************************** */
    /*                            STUDENTE                               */
    /* ***************************************************************** */

    @GetMapping ( value = "/getStudenti" )
    public List<StudenteDTO> getStudenti ()
    {
        return federicoiiService.getStudenti();
    }

    @GetMapping ( value = "/getStudentiCorso" )
    public List<StudenteConCorsoDTO> getStudentiCorso ()
    {
        return federicoiiService.getStudentiCorso();
    }

    @GetMapping ( value = "/getStudenteByCodiceFiscale/{codiceFiscale}" )
    public StudenteConCorsoDTO getStudenteByCodiceFiscale (@PathVariable String codiceFiscale)
    {
        if( codiceFiscale == null || codiceFiscale.isEmpty() )
        {
            return null;
        }

        return federicoiiService.getStudenteByCodiceFiscale(codiceFiscale);
    }

    @GetMapping ( value = "/getVerificaStudenteIscrittoByCodiceFiscale/{codiceFiscale}" )
    public String getVerificaStudenteIscrittoByCodiceFiscale (@PathVariable String codiceFiscale)
    {
        if( codiceFiscale == null || codiceFiscale.isEmpty() )
        {
            return null;
        }

        return federicoiiService.getVerificaStudenteIscrittoByCodiceFiscale(codiceFiscale);
    }

    @PostMapping ( value="/insertNuovoStudente/" )
    public StudenteDTO insertNuovoStudente (@RequestBody StudenteDTO nuovoStudente)
    {
        return federicoiiService.insertNuovoStudente(nuovoStudente);
    }

    @PostMapping ( value="/iscrivereStudenteCorso/{codiceFiscale}/{nomeCorso}" )
    public String iscrivereStudenteCorso (@PathVariable String codiceFiscale, @PathVariable String nomeCorso)
    {
        if( codiceFiscale == null || codiceFiscale.isEmpty() || codiceFiscale == " " || codiceFiscale.equals("") || codiceFiscale.equals(":codiceFiscale") )
        {
            return "Il codice fiscale non può essere nullo!";
        }
        else if ( nomeCorso == null || nomeCorso.isEmpty() || nomeCorso == " " || nomeCorso.equals("") || nomeCorso.equals(":nomeCorso") )
        {
            return "Il nome del corso non può essere nullo!";
        }
        else
        {
            return federicoiiService.iscrivereStudenteCorso(codiceFiscale, nomeCorso);
        }
    }

    @PostMapping ( value="/cancellareAssegnazioneStudenteCorso/{codiceFiscale}/{nomeCorso}" )
    public String cancellareAssegnazioneStudenteCorso (@PathVariable String codiceFiscale, @PathVariable String nomeCorso)
    {
        if( codiceFiscale == null || codiceFiscale.isEmpty() || codiceFiscale == " " || codiceFiscale.equals("") || codiceFiscale.equals(":codiceFiscale") )
        {
            return "Il codice fiscale non può essere nullo!";
        }
        else if ( nomeCorso == null || nomeCorso.isEmpty() || nomeCorso == " " || nomeCorso.equals("") || nomeCorso.equals(":nomeCorso") )
        {
            return "Il nome del corso non può essere nullo!";
        }
        else
        {
            return federicoiiService.cancellareAssegnazioneStudenteCorso(codiceFiscale, nomeCorso);
        }
    }

}