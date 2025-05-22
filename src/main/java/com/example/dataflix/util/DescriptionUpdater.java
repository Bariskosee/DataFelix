package com.example.dataflix.util;

import com.example.dataflix.model.Movie;
import com.example.dataflix.model.Series;
import com.example.dataflix.repository.MovieRepository;
import com.example.dataflix.repository.SeriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Utility class to update movie and series descriptions on application startup
 */
@Component
public class DescriptionUpdater implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DescriptionUpdater.class);

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    @Override
    public void run(String... args) {
        try {
            logger.info("Starting to update movie and series descriptions");
            updateMovieDescriptions();
            updateSeriesDescriptions();
            logger.info("Successfully updated movie and series descriptions");
        } catch (Exception e) {
            logger.error("Error updating descriptions: {}", e.getMessage(), e);
        }
    }

    private void updateMovieDescriptions() {
        Map<Integer, String> movieDescriptions = new HashMap<>();
        
        // Add all movie descriptions
        movieDescriptions.put(1, "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.");
        movieDescriptions.put(2, "While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.");
        movieDescriptions.put(3, "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.");
        movieDescriptions.put(4, "A mean lord exiles fairytale creatures to the swamp of a grumpy ogre, who must go on a quest and rescue a princess for the lord in order to get his land back.");
        movieDescriptions.put(5, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        movieDescriptions.put(6, "The story of American scientist J. Robert Oppenheimer and his role in the development of the atomic bomb during World War II.");
        movieDescriptions.put(7, "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
        movieDescriptions.put(8, "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.");
        movieDescriptions.put(9, "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.");
        movieDescriptions.put(10, "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.");
        movieDescriptions.put(11, "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.");
        movieDescriptions.put(12, "As Harvard student Mark Zuckerberg creates the social networking site that would become known as Facebook, he is sued by the twins who claimed he stole their idea, and by the co-founder who was later squeezed out of the business.");
        movieDescriptions.put(13, "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.");
        movieDescriptions.put(14, "A concierge at a prestigious European hotel becomes the prime suspect in a murder investigation while trying to prove his innocence with the help of a trusted lobby boy.");
        movieDescriptions.put(15, "A promising young drummer enrolls at a cut-throat music conservatory where his dreams of greatness are mentored by an instructor who will stop at nothing to realize a student's potential.");
        movieDescriptions.put(16, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
        movieDescriptions.put(17, "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.");
        movieDescriptions.put(18, "The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.");
        movieDescriptions.put(19, "With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation-owner in Mississippi.");
        movieDescriptions.put(20, "Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.");
        movieDescriptions.put(21, "A committed dancer struggles to maintain her sanity after winning the lead role in a production of Tchaikovsky's \"Swan Lake\".");
        movieDescriptions.put(22, "A frontiersman on a fur trading expedition in the 1820s fights for survival after being mauled by a bear and left for dead by members of his own hunting team.");
        movieDescriptions.put(23, "An aging Chinese immigrant is swept up in an insane adventure, where she alone can save the world by exploring other universes connecting with the lives she could have led.");
        movieDescriptions.put(24, "A Korean family starts a farm in 1980s Arkansas.");
        movieDescriptions.put(25, "After landing the gig of a lifetime, a New York jazz pianist suddenly finds himself trapped in a strange land between Earth and the afterlife.");

        // Update each movie description
        for (Map.Entry<Integer, String> entry : movieDescriptions.entrySet()) {
            try {
                Optional<Movie> movieOpt = movieRepository.findById(entry.getKey());
                if (movieOpt.isPresent()) {
                    Movie movie = movieOpt.get();
                    if (movie.getAgeRequirement() == null) {
                        movie.setAgeRequirement(0); // Set default value if null
                    }
                    movie.setDescription(entry.getValue());
                    movieRepository.save(movie);
                    logger.debug("Updated description for movie ID: {}", entry.getKey());
                } else {
                    logger.warn("Movie with ID {} not found", entry.getKey());
                }
            } catch (Exception e) {
                logger.error("Error updating movie with ID {}: {}", entry.getKey(), e.getMessage(), e);
            }
        }
    }

    private void updateSeriesDescriptions() {
        Map<Integer, String> seriesDescriptions = new HashMap<>();
        
        // Add all series descriptions
        seriesDescriptions.put(1, "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.");
        seriesDescriptions.put(2, "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.");
        seriesDescriptions.put(3, "A family saga with a supernatural twist, set in a German town where the disappearance of two young children exposes the relationships among four families.");
        seriesDescriptions.put(4, "Follows the personal and professional lives of six twenty to thirty-something-year-old friends living in Manhattan.");
        seriesDescriptions.put(5, "A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.");
        seriesDescriptions.put(6, "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.");
        seriesDescriptions.put(7, "Follows the political rivalries and romance of Queen Elizabeth II's reign and the events that shaped the second half of the twentieth century.");
        seriesDescriptions.put(8, "A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.");
        seriesDescriptions.put(9, "Geralt of Rivia, a solitary monster hunter, struggles to find his place in a world where people often prove more wicked than beasts.");
        seriesDescriptions.put(10, "A Congressman works with his equally conniving wife to exact revenge on the people who betrayed him.");
        seriesDescriptions.put(11, "A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.");
        seriesDescriptions.put(12, "A father recounts to his children - through a series of flashbacks - the journey he and his four best friends took leading up to him meeting their mother.");
        seriesDescriptions.put(13, "The travels of a lone bounty hunter in the outer reaches of the galaxy, far from the authority of the New Republic.");
        seriesDescriptions.put(14, "Comedy series following the exploits of Det. Jake Peralta and his diverse, lovable colleagues as they police the NYPD's 99th Precinct.");
        seriesDescriptions.put(15, "The trials and tribulations of criminal lawyer Jimmy McGill in the time before he established his strip-mall law office in Albuquerque, New Mexico.");
        seriesDescriptions.put(16, "Orphaned at the tender age of nine, prodigious introvert Beth Harmon discovers and masters the game of chess in 1960s USA. But child stardom comes at a price.");
        seriesDescriptions.put(17, "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.");
        seriesDescriptions.put(18, "An anthology series exploring a twisted, high-tech multiverse where humanity's greatest innovations and darkest instincts collide.");
        seriesDescriptions.put(19, "BoJack Horseman was the star of the hit television show \"Horsin' Around\" in the '90s, now he's washed up, living in Hollywood, complaining about everything, and wearing colorful sweaters.");
        seriesDescriptions.put(20, "A group of vigilantes set out to take down corrupt superheroes who abuse their superpowers.");
        seriesDescriptions.put(21, "An animated series that follows the exploits of a super scientist and his not-so-bright grandson.");
        seriesDescriptions.put(22, "An unusual group of robbers attempt to carry out the most perfect robbery in Spanish history - stealing 2.4 billion euros from the Royal Mint of Spain.");
        seriesDescriptions.put(23, "A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar, as well as the many other drug kingpins who plagued the country through the years.");
        seriesDescriptions.put(24, "Follows Wednesday Addams' years as a student, when she attempts to master her emerging psychic ability, thwart a killing spree, and solve the mystery that embroiled her parents.");
        seriesDescriptions.put(25, "A family of former child heroes, now grown apart, must reunite to continue to protect the world.");

        // Update each series description
        for (Map.Entry<Integer, String> entry : seriesDescriptions.entrySet()) {
            try {
                Optional<Series> seriesOpt = seriesRepository.findById(entry.getKey());
                if (seriesOpt.isPresent()) {
                    Series series = seriesOpt.get();
                    if (series.getAgeRequirement() == null) {
                        series.setAgeRequirement(0); // Set default value if null
                    }
                    series.setDescription(entry.getValue());
                    seriesRepository.save(series);
                    logger.debug("Updated description for series ID: {}", entry.getKey());
                } else {
                    logger.warn("Series with ID {} not found", entry.getKey());
                }
            } catch (Exception e) {
                logger.error("Error updating series with ID {}: {}", entry.getKey(), e.getMessage(), e);
            }
        }
    }
}
