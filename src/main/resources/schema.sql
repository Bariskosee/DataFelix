-- Add watchlist table if it doesn't exist
CREATE TABLE IF NOT EXISTS `watchlist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `content_id` int NOT NULL,
  `content_type` varchar(10) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `watchlist_user_idx` (`user_id`),
  CONSTRAINT `watchlist_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
);

-- Add watched table if it doesn't exist
CREATE TABLE IF NOT EXISTS `watched` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `content_id` int NOT NULL,
  `content_type` varchar(10) NOT NULL,
  `watch_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `watched_user_idx` (`user_id`),
  CONSTRAINT `watched_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
);
