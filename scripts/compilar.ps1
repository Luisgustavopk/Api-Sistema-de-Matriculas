$ErrorActionPreference = 'Stop'
$raizProjeto = Split-Path -Parent $PSScriptRoot
Push-Location $raizProjeto
try {
    & .\mvnw.cmd verify
    if ($LASTEXITCODE -ne 0) {
        throw 'A compilação ou os testes falharam.'
    }
} finally {
    Pop-Location
}
