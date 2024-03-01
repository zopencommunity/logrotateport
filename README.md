[![Automatic version updates](https://github.com/ZOSOpenTools/logrotateport/actions/workflows/bump.yml/badge.svg)](https://github.com/ZOSOpenTools/logrotateport/actions/workflows/bump.yml)

# logrotate

The logrotate utility is designed to simplify the administration of log files on a system which generates a lot of log files.

# Example:

## Create Configuration File:

By default, logrotate uses configuration files located in /etc/logrotate.d/. 

However, you can create a custom file in your home directory to manage specific application logs.

```
vim ~/myapp_logrotate.conf
```

## Configure Logrotate:

Specify the log files, rotation frequency, and actions within the configuration file. Here's a sample:

```
/path/to/your/log/file.log {
  rotate 5       # Keep up to 5 rotated logs
  weekly         # Rotate logs weekly (other options: daily, monthly, yearly)
  compress        # Compress rotated logs with gzip
  missingok       # Don't report errors for missing logs
  notifempty     # Don't rotate if the log is empty
}
```

## Test Logrotate Configuration:

Test your configuration without waiting for the scheduled rotation:

```
logrotate -s status.txt -d ~/myapp_logrotate.conf
```

To force immediate log rotation, run:

```
logrotate -f ~/myapp_logrotate.conf
```
