-- Create movie_comments table
CREATE TABLE IF NOT EXISTS movie_comments (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    movie_id INT NOT NULL,
    comment_text VARCHAR(1000) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_movie_comment_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_movie_comment_movie FOREIGN KEY (movie_id) REFERENCES movie(movie_id) ON DELETE CASCADE
);

-- Create series_comments table
CREATE TABLE IF NOT EXISTS series_comments (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    series_id INT NOT NULL,
    comment_text VARCHAR(1000) NOT NULL,
    comment_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_series_comment_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_series_comment_series FOREIGN KEY (series_id) REFERENCES series(series_id) ON DELETE CASCADE
);

-- Add indexes for faster lookups
CREATE INDEX idx_movie_comments_movie_id ON movie_comments(movie_id);
CREATE INDEX idx_movie_comments_user_id ON movie_comments(user_id);
CREATE INDEX idx_series_comments_series_id ON series_comments(series_id);
CREATE INDEX idx_series_comments_user_id ON series_comments(user_id);
