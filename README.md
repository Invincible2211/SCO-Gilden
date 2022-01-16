The plugin is currently under maintenance

SQL Layout

guild

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |
| name     | VARCHAR(32) |         |
| leader | VARCHAR(32)     |         |
| level     | TINYINT |         |
| xp     | FLOAT |         |
| prefix     | VARCHAR(4) |         |
| status     | TINYINT |         |
| invUpgrades     | TINYINT |         |
| defaultRole     | VARCHAR(32) |         |
| description     | MEDIUMTEXT |         |

(for each Guild)

[uuid of Guild]

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |
| displayname     | VARCHAR(16) |         |
| role | VARCHAR(32)     |         |

[uuid of Guild].role

| name     | type        | options |
|----------|-------------|---------|
| role     | VARCHAR(32) |         |
| data     | VARCHAR(32) |         |
| priority | TINYINT     |         |

[uuid of Guild].bannend

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |
| displayname     | VARCHAR(16) |         |

[uuid of Guild].invited

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |
| displayname     | VARCHAR(16) |         |

[uuid of Guild].joinRequests

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |
| displayname     | VARCHAR(16) |         |

alianz

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |
| name     | VARCHAR(32) |         |
| leader | VARCHAR(32)     |         |
| level     | TINYINT |         |
| xp     | FLOAT |         |
| prefix     | VARCHAR(4) |         |
| status     | TINYINT |         |
| defaultRole     | VARCHAR(32) |         |
| description     | MEDIUMTEXT |         |

(for each Alianz)

[uuid of Alianz]

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |
| role     | VARCHAR(32) |         |

[uuid of Alianz].role

| name     | type        | options |
|----------|-------------|---------|
| role     | VARCHAR(32) |         |
| data     | VARCHAR(32) |         |
| priority | TINYINT     |         |

[uuid of Alianz].bannend

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |

[uuid of Alianz].invited

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |

[uuid of Alianz].joinRequests

| name     | type        | options |
|----------|-------------|---------|
| uuid     | VARCHAR(32) |         |

war

| name     | type        | options |
|----------|-------------|---------|
| uuid1     | VARCHAR(32) |         |
| uuid2     | VARCHAR(32) |         |
| beginn | DATETIME     |         |
