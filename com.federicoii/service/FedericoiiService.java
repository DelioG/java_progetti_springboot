package universita.federicoii.service;

import universita.federicoii.dto.*;
import universita.federicoii.entity.*;
import universita.federicoii.mapper.*;
import universita.federicoii.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FedericoiiService
{

    /* ------------------------------- */
    /*            REPOSITORY           */
    /* ------------------------------- */

    @Autowired
    CorsoRepository corsoRepository;

    @Autowired
    DocenteRepository docenteRepository;

    @Autowired
    StudenteRepository studenteRepository;

    /* -------------------------------- */
    /*              MAPPERS             */
    /* -------------------------------- */

    @Autowired
    CorsoMapper corsoMapper;

    @Autowired
    DocenteMapper docenteMapper;

    @Autowired
    StudenteMapper studenteMapper;

    @Autowired
    CorsoConStudentiMapper corsoConStudentiMapper;

    @Autowired
    CorsoConDocenteMapper corsoConDocenteMapper;

    @Autowired
    DocenteConCorsoMapper docenteConCorsoMapper;

    @Autowired
    StudenteConCorsoMapper studenteConCorsoMapper;

    /* ***************************************************************** */
    /*                            METODI CORSO                           */
    /* ***************************************************************** */

    public List<CorsoDTO> getCorsi ()
    {
        return corsoMapper.corsoToDTOs( corsoRepository.findAll() );
    }

    public List<CorsoConDocenteDTO> getCorsiDocenti ()
    {
        return corsoConDocenteMapper.corsoToDTOs( corsoRepository.findAll() );
    }

    public List<CorsoConStudentiDTO> getCorsiStudenti ()
    {
        return corsoConStudentiMapper.corsoToDTOs( corsoRepository.findAll() );
    }

    public CorsoDTO getCorsoByNome (String nome)
    {
        return corsoMapper.corsoToDTO( corsoRepository.findCorsoByName(nome) );
    }

    public CorsoDTO insertNuovoCorso (CorsoDTO nuovoCorso)
    {
        return corsoMapper.corsoToDTO( corsoRepository.save( corsoMapper.corsoToEntity( nuovoCorso ) ) );
    }

    /* ***************************************************************** */
    /*                           METODI DOCENTE                          */
    /* ***************************************************************** */

    public List<DocenteDTO> getDocenti ()
    {
        return docenteMapper.docenteToDTOs( docenteRepository.findAll() );
    }

    public List<DocenteConCorsoDTO> getDocentiCorso ()
    {
        return docenteConCorsoMapper.docenteToDTOs( docenteRepository.findAll() );
    }

    public String getVerificaDocenteResponsabileCorso (String codiceFiscale)
    {
        DocenteConCorsoDTO docenteDTO = docenteConCorsoMapper.docenteToDTO( docenteRepository.findDocenteByCodiceFiscale( codiceFiscale ) );

        if( docenteDTO.getId() == null )
        {
            return "ERRORE: il docente non è presente nel database.";
        }
        else if( docenteDTO.getCorso().getNome() == null )
        {
            return "AVVISO: il docente non è responsabile di alcun corso";
        }
        else
        {
            return "AVVISO: il docente è già responsabile del corso [" + docenteDTO.getCorso().getNome() + "]";
        }
    }

    public DocenteDTO insertNuovoDocente (DocenteDTO nuovoDocente)
    {
        return docenteMapper.docenteToDTO( docenteRepository.save( docenteMapper.docenteToEntity( nuovoDocente ) ) );
    }

    public String assegnareDocenteCorso (String codiceFiscale, String nomeCorso)
    {
        // Come prima cosa cerco nel database il docente ed il corso passati come parametri e li assegno a delle variabili che potrò utilizzare anche più avanti.
        // Controllo poi se il docente ed il corso effettivamente esistono, oppure se non sono stati trovati nel database.
        // Se il docente ed il corso esistono, mi accerto che il docente non sia già assegnato ad un corso di laurea.
        // Se il docente non è già responsabile di un corso di laurea procedo ad assegarlo al corso di laurea specificato dall'utente.

        DocenteConCorsoDTO docenteDTO = docenteConCorsoMapper.docenteToDTO( docenteRepository.findDocenteByCodiceFiscale( codiceFiscale ) );
        CorsoConDocenteDTO corsoDTO   = corsoConDocenteMapper.corsoToDTO( corsoRepository.findCorsoByName( nomeCorso ) );

        if ( docenteDTO.getId() == null )
        {
            return "ERRORE: il docente inserito non esiste!";
        }
        else if ( corsoDTO.getId() == null )
        {
            return "ERRORE: il corso inserito non esiste!";
        }
        else if ( docenteDTO.getCorso().getId() != null )
        {
            return "AVVISO: il docente è già responsabile del corso di [" + docenteDTO.getCorso().getNome() + "]!";
        }
        else if ( corsoDTO.getDocente().getId() != null )
        {
            return "ERRORE: c'è già un docente assegnato al corso di laurea selezionato!";
        }

        // Ricerco il docente senza corso.
        DocenteDTO docente = docenteMapper.docenteToDTO( docenteRepository.findDocenteByCodiceFiscale( docenteDTO.getCodiceFiscale() ) );

        // Lo assegno al corso che ho trovato precedentemente.
        corsoDTO.setDocente( docente );

        // Prima di aggiornare i dati sul database converto il corso in entity.
        Corso corsoDaModificare = corsoConDocenteMapper.corsoToEntity( corsoDTO );
        corsoRepository.save( corsoDaModificare );

        return "AVVISO: docente assegnato correttamente al corso [" + corsoDaModificare.getNome() + "]!";
    }

    public String cancellareAssegnazioneDocenteCorso (String codiceFiscale, String nomeCorso)
    {
        // Come prima cosa cerco nel database il docente ed il corso passati come parametri e li assegno a delle variabili che potrò utilizzare anche più avanti.
        // Controllo poi se il docente ed il corso effettivamente esistono, oppure se non sono stati trovati nel database.
        // Se il docente ed il corso esistono, mi accerto che il corso inserito dall'utente e quello del docente corrispondano.
        // Se il docente è responsabile di un corso ed il corso inserito corrisponde a quello del docente, procedo a rimuovere il docente dal corso.

        DocenteConCorsoDTO docenteDTO   = docenteConCorsoMapper.docenteToDTO( docenteRepository.findDocenteByCodiceFiscale( codiceFiscale ) );
        CorsoConDocenteDTO corsoCDDTO   = corsoConDocenteMapper.corsoToDTO( corsoRepository.findCorsoByName( nomeCorso ) );

        if ( docenteDTO.getId() == null )
        {
            return "ERRORE: il docente inserito non esiste!";
        }
        else if ( corsoCDDTO.getId() == null )
        {
            return "ERRORE: il corso inserito non esiste!";
        }
        else if ( docenteDTO.getCorso().getNome() == null )
        {
            return "ERRORE: il docente non è responsabile di alcun corso!";
        }
        else if( docenteDTO.getCorso().getNome() != corsoCDDTO.getNome() )
        {
            return "ERRORE: il corso inserito non corrisponde con quello del docente!";
        }

        // Aggiorno i dati sul database
        Corso corsoDaAggiornare = corsoConDocenteMapper.corsoToEntity( corsoCDDTO );
        corsoDaAggiornare.setDocente( null );
        corsoRepository.save( corsoDaAggiornare );

        return "AVVISO: docente rimosso correttamente dal corso [" + corsoDaAggiornare.getNome() + "]!";
    }

    /* ***************************************************************** */
    /*                          METODI STUDENTE                          */
    /* ***************************************************************** */

    public List<StudenteDTO> getStudenti ()
    {
        return studenteMapper.studenteToDTOs( studenteRepository.findAll() );
    }

    public List<StudenteConCorsoDTO> getStudentiCorso ()
    {
        return studenteConCorsoMapper.studenteToDTOs( studenteRepository.findAll() );
    }

    public StudenteConCorsoDTO getStudenteByCodiceFiscale (String codiceFiscale)
    {
        return studenteConCorsoMapper.studenteToDTO( studenteRepository.findStudenteByCodiceFiscale( codiceFiscale ) );
    }

    public String getVerificaStudenteIscrittoByCodiceFiscale (String codiceFiscale)
    {
        StudenteConCorsoDTO studenteDTO = studenteConCorsoMapper.studenteToDTO( studenteRepository.findStudenteByCodiceFiscale( codiceFiscale ) );

        if( studenteDTO.getId() == null )
        {
            return "ERRORE: lo studente non è presente nel database.";
        }
        else if ( studenteDTO.getCorso().getNome() == null )
        {
            return "AVVISO: lo studente non è iscritto a nessun corso.";
        }
        else
        {
            return "AVVISO: lo studente è già iscritto al corso di [" + studenteDTO.getCorso().getNome() + "].";
        }
    }

    public StudenteDTO insertNuovoStudente (StudenteDTO nuovoStudente)
    {
        return studenteMapper.studenteToDTO( studenteRepository.save( studenteMapper.studenteToEntity( nuovoStudente ) ) );
    }

    public String iscrivereStudenteCorso (String codiceFiscale, String nomeCorso)
    {
        // Come prima cosa cerco nel database lo studente ed il corso passati come parametri e li assegno a delle variabili che potrò utilizzare anche più avanti.
        // Controllo poi se lo studente ed il corso effettivamente esistono, oppure se non sono stati trovati nel database.
        // Se lo studente ed il corso esistono, mi accerto che lo studente non sia già iscritto ad un corso di laurea.
        // Se lo studente non è già iscritto ad un corso di laurea procedo ad assegarlo al corso di laurea specificato dall'utente.

        StudenteConCorsoDTO studenteDTO = studenteConCorsoMapper.studenteToDTO( studenteRepository.findStudenteByCodiceFiscale( codiceFiscale ) );
        CorsoDTO corsoDTO               = corsoMapper.corsoToDTO( corsoRepository.findCorsoByName(nomeCorso) );

        if ( studenteDTO.getId() == null )
        {
            return "ERRORE: lo studente inserito non esiste!";
        }
        else if ( corsoDTO.getId() == null )
        {
            return "ERRORE: il corso inserito non esiste!";
        }
        else if ( studenteDTO.getCorso().getId() != null )
        {
            return "AVVISO: lo studente è già iscritto al corso di [" + studenteDTO.getCorso().getNome() + "]!";
        }

        // Assegno allo studente il corso precedentemente trovato (cercato sul database con nomeCorso).
        studenteDTO.setCorso( corsoDTO );

        // Inserimento dello studente sul database.
        Studente studenteDaAssegnare = studenteConCorsoMapper.studenteToEntity( studenteDTO );
        studenteRepository.save( studenteDaAssegnare );

        // Update del numero degli studenti del corso.
        corsoDTO.setNumeroStudenti( corsoDTO.getNumeroStudenti() + 1 );
        Corso corso = corsoMapper.corsoToEntity( corsoDTO );
        corsoRepository.save( corso );

        return "AVVISO: studente assegnato correttamente al corso [" + studenteDaAssegnare.getCorso().getNome() + "]!";
    }

    public String cancellareAssegnazioneStudenteCorso (String codiceFiscale, String nomeCorso)
    {
        // Come prima cosa cerco nel database lo studente ed il corso passati come parametri e li assegno a delle variabili che potrò utilizzare anche più avanti.
        // Controllo poi se lo studente ed il corso effettivamente esistono, oppure se non sono stati trovati nel database.
        // Se lo studente ed il corso esistono, mi accerto che il corso inserito dall'utente e quello dello studente corrispondano.
        // Se lo studente è assegnato già ad un corso ed il corso inserito corrisponde a quello dello studente, procedo a rimuovere lo studente dal corso.

        StudenteConCorsoDTO studenteDTO = studenteConCorsoMapper.studenteToDTO( studenteRepository.findStudenteByCodiceFiscale( codiceFiscale ) );
        CorsoConStudentiDTO corsoDTO    = corsoConStudentiMapper.corsoToDTO( corsoRepository.findCorsoByName( nomeCorso ) );

        if ( studenteDTO.getId() == null )
        {
            return "ERRORE: lo studente inserito non esiste!";
        }
        else if ( corsoDTO.getId() == null )
        {
            return "ERRORE: il corso inserito non esiste!";
        }
        else if( studenteDTO.getCorso().getNome() == null )
        {
            return "ERRORE: lo studente non è assegnato a nessun corso!";
        }
        else if ( studenteDTO.getCorso().getNome() != corsoDTO.getNome() )
        {
            return "ERRORE: il corso inserito non corrisponde con quello dello studente!";
        }

        // Rimozione dello studente dal database.
        Studente studenteDaAggiornare = studenteConCorsoMapper.studenteToEntity( studenteDTO );
        studenteDaAggiornare.setCorso( null );
        studenteRepository.save( studenteDaAggiornare );

        // Update del numero degli studenti del corso.
        Corso corsoDaAggiornare = corsoConStudentiMapper.corsoToEntity( corsoDTO );
        corsoDaAggiornare.setNumeroStudenti( corsoDaAggiornare.getNumeroStudenti() - 1 );
        corsoRepository.save( corsoDaAggiornare );

        return "AVVISO: studente rimosso correttamente dal corso [" + corsoDaAggiornare.getNome() + "]!";
    }

}